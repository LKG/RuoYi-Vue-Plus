package org.dromara.common.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 公告通知范围枚举
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum NoticeScope implements BaseEnum<Integer> {

    /**
     * 所有人
     */
    ALL(0, "所有人"),


    /**
     * 指定部门
     */
    DEPT(1, "指定部门"),
    /**
     * 指定用户
     */
    USER(2, "指定用户"),
    ;

    private final Integer value;
    private final String description;
}
