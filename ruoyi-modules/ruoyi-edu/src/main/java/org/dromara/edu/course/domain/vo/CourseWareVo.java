package org.dromara.edu.course.domain.vo;

import org.dromara.edu.course.domain.CourseWare;
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
 * 课件视图对象 edu_course_ware
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CourseWare.class)
public class CourseWareVo implements Serializable {

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
     * 描述
     */
    @ExcelProperty(value = "描述")
    private String description;

    /**
     * 关联课程ID
     */
    @ExcelProperty(value = "关联课程ID")
    private Long courseId;

    /**
     * 关联资源id
     */
    @ExcelProperty(value = "关联资源id")
    private Long resourceId;

    /**
     * 课件地址
     */
    @ExcelProperty(value = "课件地址")
    private String fileUrl;

    /**
     *  类型 0：视频，1：图文
     */
    @ExcelProperty(value = " 类型 0：视频，1：图文")
    private Long type;


}
