package org.dromara.edu.exam.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;

/**
 * 答卷状态
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum PaperRecordStatus implements BaseEnum<Integer> {

    /**
     * 待批改
     */
    PENDING(1,"待批改"),
    /**
     * 已批改ClassWay
     */
    SUCCESS(2,"已批改"),
    ;
    private final Integer value;

    private final String description;
}
