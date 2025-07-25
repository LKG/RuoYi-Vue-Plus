package org.dromara.edu.course.service;

import org.dromara.edu.course.domain.vo.CourseVo;
import org.dromara.edu.course.domain.bo.CourseBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 课程信息Service接口
 *
 * @author GG
 * @date 2025-07-24
 */
public interface ICourseService {

    /**
     * 查询课程信息
     *
     * @param id 主键
     * @return 课程信息
     */
    CourseVo queryById(Long id);

    /**
     * 分页查询课程信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课程信息分页列表
     */
    TableDataInfo<CourseVo> queryPageList(CourseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的课程信息列表
     *
     * @param bo 查询条件
     * @return 课程信息列表
     */
    List<CourseVo> queryList(CourseBo bo);

    /**
     * 新增课程信息
     *
     * @param bo 课程信息
     * @return 是否新增成功
     */
    Boolean insertByBo(CourseBo bo);

    /**
     * 修改课程信息
     *
     * @param bo 课程信息
     * @return 是否修改成功
     */
    Boolean updateByBo(CourseBo bo);

    /**
     * 校验并批量删除课程信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
