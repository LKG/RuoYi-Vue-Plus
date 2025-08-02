package org.dromara.edu.course.service;

import org.dromara.edu.course.domain.vo.CourseChapterVo;
import org.dromara.edu.course.domain.bo.CourseChapterBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 课程章节Service接口
 *
 * @author gg
 * @date 2025-07-30
 */
public interface ICourseChapterService {

    /**
     * 查询课程章节
     *
     * @param id 主键
     * @return 课程章节
     */
    CourseChapterVo queryById(Long id);

    /**
     * 分页查询课程章节列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课程章节分页列表
     */
    TableDataInfo<CourseChapterVo> queryPageList(CourseChapterBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的课程章节列表
     *
     * @param bo 查询条件
     * @return 课程章节列表
     */
    List<CourseChapterVo> queryList(CourseChapterBo bo);

    /**
     * 新增课程章节
     *
     * @param bo 课程章节
     * @return 是否新增成功
     */
    Boolean insertByBo(CourseChapterBo bo);

    /**
     * 修改课程章节
     *
     * @param bo 课程章节
     * @return 是否修改成功
     */
    Boolean updateByBo(CourseChapterBo bo);

    /**
     * 校验并批量删除课程章节信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
