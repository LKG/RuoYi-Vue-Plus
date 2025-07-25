package org.dromara.edu.course.service;

import cn.hutool.core.lang.tree.Tree;
import org.dromara.edu.course.domain.vo.CourseCategoryVo;
import org.dromara.edu.course.domain.bo.CourseCategoryBo;

import java.util.Collection;
import java.util.List;

/**
 * 课程分类管理Service接口
 *
 * @author gg
 * @date 2025-07-23
 */
public interface ICourseCategoryService {

    /**
     * 查询课程分类管理
     *
     * @param id 主键
     * @return 课程分类管理
     */
    CourseCategoryVo queryById(Long id);


    /**
     * 查询符合条件的课程分类管理列表
     *
     * @param bo 查询条件
     * @return 课程分类管理列表
     */
    List<CourseCategoryVo> queryList(CourseCategoryBo bo);

    /**
     * 查询符合条件的课程分类树
     * @param bo 查询条件
     * @return 课程分类树
     */
    List<Tree<Long>> selectCateTreeList(CourseCategoryBo bo);
    List<Tree<Long>> buildCateTreeSelect(List<CourseCategoryVo> cateList);
    /**
     * 新增课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否新增成功
     */
    Boolean insertByBo(CourseCategoryBo bo);

    /**
     * 修改课程分类管理
     *
     * @param bo 课程分类管理
     * @return 是否修改成功
     */
    Boolean updateByBo(CourseCategoryBo bo);
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
