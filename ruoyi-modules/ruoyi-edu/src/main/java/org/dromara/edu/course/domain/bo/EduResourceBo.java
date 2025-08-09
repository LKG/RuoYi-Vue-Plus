package org.dromara.edu.course.domain.bo;

import org.dromara.edu.course.domain.EduResource;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 资源业务对象 edu_resource
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = EduResource.class, reverseConvertGenerate = false)
public class EduResourceBo extends BaseEntity {

    /**
     * 主键
     */
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
    @NotNull(message = "分类id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long categoryId;

    /**
     * 资源类型
     */
    @NotNull(message = "资源类型不能为空", groups = { AddGroup.class, EditGroup.class })
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


}
