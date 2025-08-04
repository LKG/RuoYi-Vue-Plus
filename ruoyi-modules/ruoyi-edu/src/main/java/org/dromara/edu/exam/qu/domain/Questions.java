package org.dromara.edu.exam.qu.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 题库对象 exam_questions
 *
 * @author gg
 * @date 2025-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("exam_questions")
public class Questions extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 题目
     */
    private String title;

    /**
     * 题目类型：1.单选、2.多选、3.判断、4.简答、5.填空
     */
    private Integer questionsType;

    /**
     * 正确选项
     */
    private String correctOptionKey;

    /**
     * 题目解析
     */
    private String questionsAnalyze;

    /**
     * 分数
     */
    private Long score;

    /**
     * 难度
     */
    private String difficulty;

    /**
     * 数据来源
     */
    private Long sourceType;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


}
