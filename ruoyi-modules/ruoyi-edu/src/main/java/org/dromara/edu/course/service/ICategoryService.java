package org.dromara.edu.course.service;

import cn.hutool.core.lang.tree.Tree;
import org.dromara.edu.course.domain.vo.CategoryVo;
import org.dromara.edu.course.domain.bo.CategoryBo;

import java.util.Collection;
import java.util.List;

/**
 * 课程分类管理Service接口
 *
 * @author gg
 * @date 2025-07-23
 */
public interface ICategoryService {

    /**
     * 查询课程分类管理
     *
     * @param id 主键
     * @return 课程分类管理
     */
    CategoryVo queryById(Long id);

    /**
     * 根据id查询名称
     * @param categoryId 分类id
     * @return 分类名称
     */
    String selectNameById(Long categoryId);
    /**
     * 查询符合条件的课程分类管理列表
     *
     * @param bo 查询条件
     * @return 课程分类管理列表
     */
    List<CategoryVo> queryList(CategoryBo bo);

    /**
     * 查询符合条件的课程分类树
     * @param bo 查询条件
     * @return 课程分类树
     */
    List<Tree<Long>> selectCateTreeList(CategoryBo bo);
    List<Tree<Long>> buildCateTreeSelect(List<CategoryVo> cateList);
    /**
     * 新增课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否新增成功
     */
    Boolean insertByBo(CategoryBo bo);

    /**
     * 修改课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否修改成功
     */
    Boolean updateByBo(CategoryBo bo);
    /**
     * 是否存在子节点
     *
     * @param id 分类id
     * @return 结果
     */
    boolean hasChildById(Long id);
    /**
     * 校验并批量删除课程分类管理信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
