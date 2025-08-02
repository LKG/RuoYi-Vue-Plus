package org.dromara.edu.course.service;

import org.dromara.edu.course.domain.vo.CoursePeriodVo;
import org.dromara.edu.course.domain.bo.CoursePeriodBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 课时Service接口
 *
 * @author gg
 * @date 2025-07-30
 */
public interface ICoursePeriodService {

    /**
     * 查询课时
     *
     * @param id 主键
     * @return 课时
     */
    CoursePeriodVo queryById(Long id);

    /**
     * 分页查询课时列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课时分页列表
     */
    TableDataInfo<CoursePeriodVo> queryPageList(CoursePeriodBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的课时列表
     *
     * @param bo 查询条件
     * @return 课时列表
     */
    List<CoursePeriodVo> queryList(CoursePeriodBo bo);

    /**
     * 新增课时
     *
     * @param bo 课时
     * @return 是否新增成功
     */
    Boolean insertByBo(CoursePeriodBo bo);

    /**
     * 修改课时
     *
     * @param bo 课时
     * @return 是否修改成功
     */
    Boolean updateByBo(CoursePeriodBo bo);

    /**
     * 校验并批量删除课时信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
