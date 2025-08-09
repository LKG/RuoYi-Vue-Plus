package org.dromara.edu.course.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 资源对象 edu_resource
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_resource")
public class EduResource extends TenantEntity {

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
     * 封面
     */
    private String coverUrl;
    /**
     * 文件地址
     */
    private String fileUrl;
    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 资源类型
     */
    private Long type;

    /**
     * 课程状态
     */
    private Long checkStatus;

    /**
     * 所属标签
     */
    private String tagIds;

    /**
     * 资源描述
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
     * 是否发布
     */
    private Long isPublished;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


}
