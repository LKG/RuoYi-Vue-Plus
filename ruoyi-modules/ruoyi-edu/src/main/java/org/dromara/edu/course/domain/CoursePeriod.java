package org.dromara.edu.course.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 课时对象 edu_course_period
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_course_period")
public class CoursePeriod extends TenantEntity {

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
    private String content;

    /**
     * 描述
     */
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
    private String fileUrl;

    /**
     *  类型 0：视频，1：图文
     */
    private Long type;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


}
