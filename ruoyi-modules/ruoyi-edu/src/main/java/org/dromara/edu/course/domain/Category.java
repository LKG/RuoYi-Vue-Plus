package org.dromara.edu.course.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 课程分类管理对象 edu_course_category
 *
 * @author gg
 * @date 2025-07-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("edu_course_category")
public class Category extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 排序号
     */
    private Integer sortNum;

    /**
     * 分类层级
     */
    private Long categoryLevel;
    /**
     * 祖级列表
     */
    private String ancestors;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


}
