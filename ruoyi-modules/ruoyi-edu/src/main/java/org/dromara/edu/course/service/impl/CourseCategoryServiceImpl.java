package org.dromara.edu.course.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.common.core.constant.Constants;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.helper.DataBaseHelper;
import org.dromara.common.redis.utils.CacheUtils;
import org.dromara.edu.EduCacheNames;
import org.dromara.edu.course.domain.CourseCategory;
import org.dromara.edu.course.domain.bo.CourseCategoryBo;
import org.dromara.edu.course.domain.vo.CourseCategoryVo;
import org.dromara.edu.course.mapper.CourseCategoryMapper;
import org.dromara.edu.course.service.ICourseCategoryService;
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
public class CourseCategoryServiceImpl implements ICourseCategoryService {

    private final CourseCategoryMapper baseMapper;

    /**
     * 查询课程分类管理
     *
     * @param id 主键
     * @return 课程分类管理
     */
    @Override
    public CourseCategoryVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }


    /**
     * 查询符合条件的课程分类管理列表
     *
     * @param bo 查询条件
     * @return 课程分类管理列表
     */
    @Override
    public List<CourseCategoryVo> queryList(CourseCategoryBo bo) {
        LambdaQueryWrapper<CourseCategory> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CourseCategory> buildQueryWrapper(CourseCategoryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CourseCategory> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CourseCategory::getId);
        lqw.like(StringUtils.isNotBlank(bo.getName()), CourseCategory::getName, bo.getName());
        lqw.eq(bo.getParentId() != null, CourseCategory::getParentId, bo.getParentId());
        lqw.eq(bo.getCategoryLevel() != null, CourseCategory::getCategoryLevel, bo.getCategoryLevel());
        return lqw;
    }

    /**
     * 新增课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CourseCategoryBo bo) {
        CourseCategory add = MapstructUtils.convert(bo, CourseCategory.class);
        assert add != null;
        String ancestors=Constants.ROOT_ANCESTORS;
        if(!bo.getParentId().equals(0L)){
            CourseCategory info = baseMapper.selectById(bo.getParentId());
            ancestors=info.getAncestors() + StringUtils.SEPARATOR + info.getParentId();
            add.setCategoryLevel(info.getCategoryLevel()+1);
        }
        add.setAncestors(ancestors);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
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
    public Boolean updateByBo(CourseCategoryBo bo) {
        CourseCategory update = MapstructUtils.convert(bo, CourseCategory.class);
        CourseCategory oldCategory = baseMapper.selectById(bo.getParentId());
        if (ObjectUtil.isNull(oldCategory)) {
            throw new ServiceException("分类不存在，无法修改");
        }
        assert update != null;
        if (!oldCategory.getParentId().equals(update.getParentId())) {
            // 如果是新父部门 则校验是否具有新父部门权限 避免越权
            CourseCategory newParentCategory = baseMapper.selectById(update.getParentId());
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
        return baseMapper.updateById(update) > 0;
    }
    /**
     * 修改子元素关系
     *
     * @param deptId       被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    private void updateChildren(Long deptId, String newAncestors, String oldAncestors) {
        List<CourseCategory> children = baseMapper.selectList(new LambdaQueryWrapper<CourseCategory>()
            .apply(DataBaseHelper.findInSet(deptId, Constants.ANCESTORS_CODE)));
        List<CourseCategory> list = new ArrayList<>();
        for (CourseCategory child : children) {
            CourseCategory cate = new CourseCategory();
            cate.setId(child.getId());
            cate.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
            list.add(cate);
        }
        if (CollUtil.isNotEmpty(list)) {
            if (baseMapper.updateBatchById(list)) {
                list.forEach(cate -> CacheUtils.evict(EduCacheNames.EDU_COURSE_CATEGORY, cate.getId()));
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
        return baseMapper.exists(new LambdaQueryWrapper<CourseCategory>()
            .eq(CourseCategory::getParentId, id));
    }
    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CourseCategory entity){
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
        return baseMapper.deleteByIds(ids) > 0;
    }
}
