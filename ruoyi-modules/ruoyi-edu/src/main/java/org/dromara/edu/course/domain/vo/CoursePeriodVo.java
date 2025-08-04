package org.dromara.edu.course.domain.vo;

import org.dromara.edu.course.domain.CoursePeriod;
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
 * 课时视图对象 edu_course_period
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = CoursePeriod.class)
public class CoursePeriodVo implements Serializable {

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
     * 关联章节id
     */
    @ExcelProperty(value = "关联章节id")
    private Long chapterId;

    /**
     * 关联资源表id
     */
    @ExcelProperty(value = "关联资源表id")
    private Long resourceId;

    /**
     * 节内容
     */
    @ExcelProperty(value = "节内容")
    private String content;

    /**
     * 描述
     */
    @ExcelProperty(value = "描述")
    private String description;

    /**
     * 时长
     */
    @ExcelProperty(value = "时长")
    private Long learnHour;

    /**
     * 关联课程ID
     */
    @ExcelProperty(value = "关联课程ID")
    private Long courseId;

    /**
     * 视频/音频地址
     */
    @ExcelProperty(value = "视频/音频地址")
    private String fileUrl;

    /**
     *  类型 0：视频，1：图文
     */
    @ExcelProperty(value = " 类型 0：视频，1：图文")
    private Long type;


}
