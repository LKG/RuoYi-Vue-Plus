package org.dromara.edu.exam.qu.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;

/**
 * @author gg
 *  试题来源枚举
 */

@Getter
@RequiredArgsConstructor
public enum QuSourceType implements BaseEnum<Integer> {

    /**
     * 题目来源
     */
    MANUAL(0,"手工添加"),
    SYSTEM(1,"系统生成"),
    INDUCTS(2,"导入"),
    ;

    private final Integer value;

    private final String description;
}
