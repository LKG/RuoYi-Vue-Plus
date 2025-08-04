package org.dromara.edu.exam.qu.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 题库选项对象 exam_questions_options
 *
 * @author gg
 * @date 2025-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("exam_questions_options")
public class QuestionsOptions extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 题库ID
     */
    private Long questionsId;

    /**
     * 选项名
     */
    private String optionName;

    /**
     * 分数
     */
    private Long score;

    /**
     * 答案
     */
    private String answer;

    /**
     * 排序字段
     */
    private Integer sortNum;

    /**
     * 选项key
     */
    private String optionKey;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @TableLogic
    private String delFlag;


}
