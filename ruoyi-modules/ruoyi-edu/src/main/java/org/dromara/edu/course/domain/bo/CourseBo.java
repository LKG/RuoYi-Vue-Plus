package org.dromara.edu.course.domain.bo;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.edu.course.domain.Course;

/**
 * 课程信息业务对象 edu_course
 *
 * @author GG
 * @date 2025-07-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Course.class, reverseConvertGenerate = false)
public class CourseBo extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否推荐
     */
    private Integer isRecommend;

    /**
     * 是否置顶
     */
    private Integer isTop;

    /**
     * 是否必修课
     */
    private Integer isRequired;

    /**
     * 课程封面
     */
    private String coverUrl;

    /**
     * 分类id
     */
    @NotNull(message = "分类id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long categoryId;

    /**
     * 课程类型
     */
    @NotNull(message = "课程类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer type;

    /**
     * 审核状态
     */
    private Integer checkStatus;

    /**
     * 所属标签
     */
    @NotBlank(message = "所属标签不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tagIds;

    /**
     * 课程描述
     */
    @NotBlank(message = "课程描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String description;

    /**
     * 收藏量
     */
    private Long collectCount;

    /**
     * 阅读量
     */
    private Long viewCount;

    /**
     * 课程来源
     */
    private Integer sourceType;

    /**
     * 是否发布
     */
    private Integer isPublished;

    /**
     * 是否精品
     */
    private Integer isPremium;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 通知范围（0：所有人；1：指定部门;2：指定用户）
     */
    @NotBlank(message = "通知范围不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer noticeScope;

    /**
     * 通知用户/部门
     */
    private String noticeUsers;

}
