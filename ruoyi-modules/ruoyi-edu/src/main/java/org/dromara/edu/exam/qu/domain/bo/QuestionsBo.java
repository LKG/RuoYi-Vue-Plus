package org.dromara.edu.exam.qu.domain.bo;

import org.dromara.edu.exam.qu.domain.Questions;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 题库业务对象 exam_questions
 *
 * @author gg
 * @date 2025-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Questions.class, reverseConvertGenerate = false)
public class QuestionsBo extends BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目
     */
    @NotBlank(message = "题目不能为空", groups = { AddGroup.class, EditGroup.class })
    private String title;

    /**
     * 题目类型：1.单选、2.多选、3.判断、4.简答、5.填空
     */
    @NotNull(message = "题目类型：1.单选、2.多选、3.判断、4.简答、5.填空不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long questionsType;

    /**
     * 正确选项
     */
    @NotBlank(message = "正确选项不能为空", groups = { AddGroup.class, EditGroup.class })
    private String correctOptionKey;

    /**
     * 题目解析
     */
    @NotBlank(message = "题目解析不能为空", groups = { AddGroup.class, EditGroup.class })
    private String questionsAnalyze;

    /**
     * 分数
     */
    @NotNull(message = "分数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long score;

    /**
     * 难度
     */
    @NotBlank(message = "难度不能为空", groups = { AddGroup.class, EditGroup.class })
    private String difficulty;

    /**
     * 数据来源
     */
    @NotNull(message = "数据来源不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long sourceType;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 分类id
     */
    private Long categoryId;


}
