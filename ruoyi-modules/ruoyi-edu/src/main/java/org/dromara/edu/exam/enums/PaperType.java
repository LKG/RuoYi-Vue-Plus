package org.dromara.edu.exam.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;

/**
 * @author gg
 * 试卷类型枚举
 */

@Getter
@RequiredArgsConstructor
public enum PaperType implements BaseEnum<Integer> {
    /**
     * 固定试卷
     */
    REGULAR(1,"固定试卷"),
    /**
     * 时段试卷
     */
    TIME(2,"时段试卷"),
    /**
     * 任务试卷
     */
    TASK(3,"任务试卷"),
    ;

    private final Integer value;

    private final String description;
}
