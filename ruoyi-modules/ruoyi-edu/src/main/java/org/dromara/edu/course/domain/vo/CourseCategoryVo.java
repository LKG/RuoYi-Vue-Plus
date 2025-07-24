package org.dromara.edu.course.domain.vo;

import org.dromara.edu.course.domain.CourseCategory;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 课程分类管理视图对象 edu_course_category
 *
 * @author gg
 * @date 2025-07-23
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CourseCategory.class)
public class CourseCategoryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 分类名称
     */
    @ExcelProperty(value = "分类名称")
    private String name;

    /**
     * 父节点id
     */
    @ExcelProperty(value = "父节点id")
    private Long parentId;

    /**
     * 排序号
     */
    @ExcelProperty(value = "排序号")
    private Long sortNum;

    /**
     * 分类层级
     */
    @ExcelProperty(value = "分类层级")
    private Long categoryLevel;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;
}
