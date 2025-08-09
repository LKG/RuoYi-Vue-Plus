package org.dromara.edu.course.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.common.core.constant.Constants;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.ObjectUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.core.utils.TreeBuildUtils;
import org.dromara.common.mybatis.helper.DataBaseHelper;
import org.dromara.common.redis.utils.CacheUtils;
import org.dromara.edu.EduCacheNames;
import org.dromara.edu.course.domain.Category;
import org.dromara.edu.course.domain.bo.CategoryBo;
import org.dromara.edu.course.domain.vo.CategoryVo;
import org.dromara.edu.course.mapper.CategoryMapper;
import org.dromara.edu.course.service.ICategoryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 课程分类管理Service业务层处理
 *
 * @author gg
 * @date 2025-07-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryMapper categoryMapper;

    /**
     * 查询课程分类管理
     *
     * @param id 主键
     * @return 课程分类管理
     */
    @Override
    public CategoryVo queryById(Long id){
        return categoryMapper.selectVoById(id);
    }


    /**
     * 查询符合条件的课程分类管理列表
     *
     * @param bo 查询条件
     * @return 课程分类管理列表
     */
    @Override
    public List<CategoryVo> queryList(CategoryBo bo) {
        LambdaQueryWrapper<Category> lqw = buildQueryWrapper(bo);
        return categoryMapper.selectVoList(lqw);
    }
    @Cacheable(cacheNames = EduCacheNames.EDU_CATEGORY, key = "#categoryId")
    @Override
    public String selectNameById(Long categoryId) {
        Category category = categoryMapper.selectOne(new LambdaQueryWrapper<Category>()
            .select(Category::getName).eq(Category::getId, categoryId));
        return ObjectUtils.notNullGetter(category, Category::getName);
    }
    /**
     * 查询符合条件的课程分类树
     * @param bo 查询条件
     * @return 课程分类树
     */
    @Override
    public List<Tree<Long>> selectCateTreeList(CategoryBo bo) {
        LambdaQueryWrapper<Category> lqw = buildQueryWrapper(bo);
        List<CategoryVo> cateList = categoryMapper.selectVoList(lqw);
        return buildCateTreeSelect(cateList);
    }
    /**
     * 构建前端所需要下拉树结构
     *
     * @param cateList 分类列表
     * @return 下拉树结构列表
     */
    @Override
    public List<Tree<Long>> buildCateTreeSelect(List<CategoryVo> cateList) {
        if (CollUtil.isEmpty(cateList)) {
            return CollUtil.newArrayList();
        }
        return TreeBuildUtils.buildMultiRoot(
            cateList,
            CategoryVo::getId,
            CategoryVo::getParentId,
            (node, treeNode) -> treeNode
                .setId(node.getId())
                .setParentId(node.getParentId())
                .setName(node.getName())
                .setWeight(node.getSortNum())
//                .putExtra("disabled", SystemConstants.DISABLE.equals(node.getStatus()))
        );
    }
    private LambdaQueryWrapper<Category> buildQueryWrapper(CategoryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Category> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(Category::getId);
        lqw.like(StringUtils.isNotBlank(bo.getName()), Category::getName, bo.getName());
        lqw.eq(bo.getParentId() != null, Category::getParentId, bo.getParentId());
        lqw.eq(bo.getCategoryLevel() != null, Category::getCategoryLevel, bo.getCategoryLevel());
        return lqw;
    }

    /**
     * 新增课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CategoryBo bo) {
        Category add = MapstructUtils.convert(bo, Category.class);
        assert add != null;
        String ancestors=Constants.ROOT_ANCESTORS;
        if(!bo.getParentId().equals(0L)){
            Category info = categoryMapper.selectById(bo.getParentId());
            ancestors=info.getAncestors() + StringUtils.SEPARATOR + info.getParentId();
            add.setCategoryLevel(info.getCategoryLevel()+1);
        }
        add.setAncestors(ancestors);
        validEntityBeforeSave(add);
        boolean flag = categoryMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CategoryBo bo) {
        Category update = MapstructUtils.convert(bo, Category.class);
        Category oldCategory = categoryMapper.selectById(bo.getParentId());
        if (ObjectUtil.isNull(oldCategory)) {
            throw new ServiceException("分类不存在，无法修改");
        }
        assert update != null;
        if (!oldCategory.getParentId().equals(update.getParentId())) {
            // 如果是新父部门 则校验是否具有新父部门权限 避免越权
            Category newParentCategory = categoryMapper.selectById(update.getParentId());
            if (ObjectUtil.isNotNull(newParentCategory)) {
                update.setCategoryLevel(newParentCategory.getCategoryLevel());
                String newAncestors = newParentCategory.getAncestors() + StringUtils.SEPARATOR + newParentCategory.getId();
                String oldAncestors = oldCategory.getAncestors();
                update.setAncestors(newAncestors);
                updateChildren(update.getId(), newAncestors, oldAncestors);
            }
        } else {
            update.setAncestors(oldCategory.getAncestors());
        }
        validEntityBeforeSave(update);
        return categoryMapper.updateById(update) > 0;
    }
    /**
     * 修改子元素关系
     *
     * @param deptId       被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    private void updateChildren(Long deptId, String newAncestors, String oldAncestors) {
        List<Category> children = categoryMapper.selectList(new LambdaQueryWrapper<Category>()
            .apply(DataBaseHelper.findInSet(deptId, Constants.ANCESTORS_CODE)));
        List<Category> list = new ArrayList<>();
        for (Category child : children) {
            Category cate = new Category();
            cate.setId(child.getId());
            cate.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
            list.add(cate);
        }
        if (CollUtil.isNotEmpty(list)) {
            if (categoryMapper.updateBatchById(list)) {
                list.forEach(cate -> CacheUtils.evict(EduCacheNames.EDU_CATEGORY, cate.getId()));
            }
        }
    }

    /**
     * 是否存在子节点
     *
     * @param id 分类id
     * @return 结果
     */
    @Override
    public boolean hasChildById(Long id) {
        return categoryMapper.exists(new LambdaQueryWrapper<Category>()
            .eq(Category::getParentId, id));
    }
    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Category entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除课程分类管理信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            ids.forEach(id->{
              boolean hasChild=  hasChildById(id);
              if(hasChild){
                  throw new ServiceException("存在子节点，无法删除");
              }
            });
        }
        return categoryMapper.deleteByIds(ids) > 0;
    }
}
