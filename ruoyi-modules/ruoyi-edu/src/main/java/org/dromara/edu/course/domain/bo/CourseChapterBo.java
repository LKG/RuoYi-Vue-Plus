package org.dromara.edu.course.domain.bo;

import org.dromara.edu.course.domain.CourseChapter;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 课程章节业务对象 edu_course_chapter
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = CourseChapter.class, reverseConvertGenerate = false)
public class CourseChapterBo extends BaseEntity {

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
    private Integer sortNum;

    /**
     * 关联课程ID
     */
    private Long courseId;

    /**
     * 章节描述
     */
    @NotBlank(message = "章节描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String description;


}
