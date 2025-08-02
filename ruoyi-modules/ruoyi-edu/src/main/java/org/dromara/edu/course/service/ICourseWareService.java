package org.dromara.edu.course.service;

import org.dromara.edu.course.domain.vo.CourseWareVo;
import org.dromara.edu.course.domain.bo.CourseWareBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 课件Service接口
 *
 * @author gg
 * @date 2025-07-30
 */
public interface ICourseWareService {

    /**
     * 查询课件
     *
     * @param id 主键
     * @return 课件
     */
    CourseWareVo queryById(Long id);

    /**
     * 分页查询课件列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课件分页列表
     */
    TableDataInfo<CourseWareVo> queryPageList(CourseWareBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的课件列表
     *
     * @param bo 查询条件
     * @return 课件列表
     */
    List<CourseWareVo> queryList(CourseWareBo bo);

    /**
     * 新增课件
     *
     * @param bo 课件
     * @return 是否新增成功
     */
    Boolean insertByBo(CourseWareBo bo);

    /**
     * 修改课件
     *
     * @param bo 课件
     * @return 是否修改成功
     */
    Boolean updateByBo(CourseWareBo bo);

    /**
     * 校验并批量删除课件信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
