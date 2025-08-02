package org.dromara.edu.exam.qu.domain.bo;

import org.dromara.edu.exam.qu.domain.QuestionsOptions;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 题库选项业务对象 exam_questions_options
 *
 * @author gg
 * @date 2025-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = QuestionsOptions.class, reverseConvertGenerate = false)
public class QuestionsOptionsBo extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 题库ID
     */
    private Long questionsId;

    /**
     * 选项名
     */
    @NotBlank(message = "选项名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String optionName;

    /**
     * 分数
     */
    @NotNull(message = "分数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long score;

    /**
     * 答案
     */
    @NotBlank(message = "答案不能为空", groups = { AddGroup.class, EditGroup.class })
    private String answer;

    /**
     * 排序字段
     */
    @NotNull(message = "排序字段不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long sortNum;

    /**
     * 选项key
     */
    @NotBlank(message = "选项key不能为空", groups = { AddGroup.class, EditGroup.class })
    private String optionKey;


}
