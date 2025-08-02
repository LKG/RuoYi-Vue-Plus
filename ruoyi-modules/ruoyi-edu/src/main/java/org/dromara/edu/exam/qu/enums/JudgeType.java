package org.dromara.edu.exam.qu.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;

/**
 * @author gg
 * 试题类型枚举
 */

@Getter
@RequiredArgsConstructor
public enum JudgeType implements BaseEnum<Integer> {

    /**
     * 题目类型：1 正确  0 错误
     */
    TRUE(1,"正确"),
    FALSE(0,"错误"),
    ;
    private final Integer value;

    private final String description;
}
