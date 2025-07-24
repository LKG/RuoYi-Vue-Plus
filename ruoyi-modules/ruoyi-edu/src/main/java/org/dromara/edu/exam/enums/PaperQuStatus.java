package org.dromara.edu.exam.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;

/**
 * 考题状态
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum PaperQuStatus implements BaseEnum<Integer> {

    /**
     * 正确
     */
    SUCCESS(1,"正确"),
    /**
     * 错题
     */
    ERROR(2,"错题"),
    /**
     * 错题已修改
     */
    MODIFIED(3,"错题已修改"),
    ;

    private final Integer value;

    private final String description;
}
