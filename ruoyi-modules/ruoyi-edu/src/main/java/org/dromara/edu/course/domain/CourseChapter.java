package org.dromara.edu.course.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 课程章节对象 edu_course_chapter
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_course_chapter")
public class CourseChapter extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序号
     */
    private Long sortNum;

    /**
     * 关联课程ID
     */
    private Long courseId;

    /**
     * 章节描述
     */
    private String description;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


}
