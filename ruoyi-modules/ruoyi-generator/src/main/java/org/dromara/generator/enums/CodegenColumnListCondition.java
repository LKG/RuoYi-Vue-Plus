package org.dromara.generator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 代码生成器的字段过滤条件枚举
 * @author gg
 */
@AllArgsConstructor
@Getter
public enum CodegenColumnListCondition {

    EQ("="),
    NE("!="),
    GT(">"),
    GTE(">="),
    LT("<"),
    LTE("<="),
    LIKE("LIKE"),
    BETWEEN("BETWEEN");

    /**
     * 条件
     */
    private final String condition;

}
