package org.dromara.edu.course.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 课程信息对象 edu_course
 *
 * @author GG
 * @date 2025-07-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_course")
public class Course extends TenantEntity {

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
     * 是否推荐
     */
    private Integer isRecommend;

    /**
     * 是否置顶
     */
    private Boolean isTop;

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
    private Long categoryId;

    /**
     * 课程类型
     */
    private Integer type;

    /**
     * 审核状态
     */
    private Integer checkStatus;

    /**
     * 所属标签
     */
    private String tagIds;

    /**
     * 课程描述
     */
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
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;

    /**
     * 通知范围（1：所有人；2：指定部门;3：指定用户）
     */
    private Integer noticeScope;

    /**
     * 通知用户/部门
     */
    private String noticeUsers;

}
