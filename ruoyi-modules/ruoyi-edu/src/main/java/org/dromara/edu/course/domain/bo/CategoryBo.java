package org.dromara.edu.course.domain.bo;

import org.dromara.edu.course.domain.Category;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 课程分类管理业务对象 edu_course_category
 *
 * @author gg
 * @date 2025-07-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Category.class, reverseConvertGenerate = false)
public class CategoryBo extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 排序号
     */
    @NotNull(message = "排序号不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer sortNum;

    /**
     * 分类层级
     */
    private Long categoryLevel;


}
