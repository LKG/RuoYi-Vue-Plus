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
public enum QuType implements BaseEnum<Integer> {

    /**
     * 题目类型：1.单选、2.多选、3.判断、4.简答、5.填空
     */
    RADIO(1,"单选题"),
    MULTI(2,"多选题"),
    JUDGE(3,"判断题"),
    ANSWER(4,"简答题"),
    FULLING(5,"填空题"),
    ;

    private final Integer value;

    private final String description;
}
