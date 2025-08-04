package org.dromara.edu.course.domain.bo;

import org.dromara.edu.course.domain.CourseWare;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 课件业务对象 edu_course_ware
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CourseWare.class, reverseConvertGenerate = false)
public class CourseWareBo extends BaseEntity {

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
    private Integer sortNum;

    /**
     * 描述
     */
    @NotBlank(message = "描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String description;

    /**
     * 关联课程ID
     */
    private Long courseId;

    /**
     * 关联资源id
     */
    @NotNull(message = "关联资源id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long resourceId;

    /**
     * 课件地址
     */
    @NotBlank(message = "课件地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String fileUrl;

    /**
     *  类型 0：视频，1：图文
     */
    private Long type;


}
