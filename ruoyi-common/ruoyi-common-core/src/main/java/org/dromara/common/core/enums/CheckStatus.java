package org.dromara.common.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *  审核状态
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum CheckStatus implements BaseEnum<Integer> {

    /**
     * 未提交
     */
    PENDING(0,"未提交"),
    
    /**
     * 审批中
     */
    CHECKING(1, "审批中"),
    /**
     *已撤回
     */
    CANCELLED(2, "已撤回"),
    /**
     *已驳回
     */
    DISMISSED(3, "已驳回"),
    /**
     *审批通过
     */
    APPROVED(4, "审批通过"),
    ;

    private final Integer value;
    private final String description;
}
