package org.dromara.common.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 上课方式
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum ClassWay implements BaseEnum<Integer> {



    /**
     * 视频课
     */
    VIDEO(1, "视频课"),

    /**
     *线下授课
     */
    OFFLINE(2, "线下授课"),

    /**
     * 直播课
     */
    LIVE(3,"直播课"),
    ;

    private final Integer value;
    private final String description;
}
