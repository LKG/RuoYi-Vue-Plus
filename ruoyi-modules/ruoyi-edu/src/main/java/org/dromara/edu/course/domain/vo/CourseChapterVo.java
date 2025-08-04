package org.dromara.edu.course.domain.vo;

import org.dromara.edu.course.domain.CourseChapter;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 课程章节视图对象 edu_course_chapter
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CourseChapter.class)
public class CourseChapterVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    private String title;

    /**
     * 排序号
     */
    @ExcelProperty(value = "排序号")
    private Integer sortNum;

    /**
     * 关联课程ID
     */
    @ExcelProperty(value = "关联课程ID")
    private Long courseId;

    /**
     * 章节描述
     */
    @ExcelProperty(value = "章节描述")
    private String description;


}
