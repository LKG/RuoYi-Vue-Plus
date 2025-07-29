package org.dromara.common.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *  状态
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum Status implements BaseEnum<Integer> {

    /**
     * 正常
     */
    NORMAL(0,"正常"),

    /**
     * 异常
     */
    DISABLE(1, "异常"),
    ;

    private final Integer value;
    private final String description;
}
