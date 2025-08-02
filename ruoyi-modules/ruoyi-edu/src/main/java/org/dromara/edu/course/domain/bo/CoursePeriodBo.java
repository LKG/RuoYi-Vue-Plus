package org.dromara.edu.course.domain.bo;

import org.dromara.edu.course.domain.CoursePeriod;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 课时业务对象 edu_course_period
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CoursePeriod.class, reverseConvertGenerate = false)
public class CoursePeriodBo extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序号
     */
    @NotNull(message = "排序号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long sortNum;

    /**
     * 关联章节id
     */
    private Long chapterId;

    /**
     * 关联资源表id
     */
    private Long resourceId;

    /**
     * 节内容
     */
    @NotBlank(message = "节内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String content;

    /**
     * 描述
     */
    @NotBlank(message = "描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String description;

    /**
     * 时长
     */
    private Long learnHour;

    /**
     * 关联课程ID
     */
    private Long courseId;

    /**
     * 视频/音频地址
     */
    @NotBlank(message = "视频/音频地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String fileUrl;

    /**
     *  类型 0：视频，1：图文
     */
    private Long type;


}
