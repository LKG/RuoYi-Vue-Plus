package org.dromara.crm.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;


/**
 * CRM 业务类型枚举
 *
 * @author GG
 */
@RequiredArgsConstructor
@Getter
public enum CrmBizType  implements BaseEnum<Integer> {

    CLUE(1, "线索"),
    CUSTOMER(2, "客户"),
    CONTACT(3, "联系人"),
    BUSINESS(4, "商机"),
    CONTRACT(5, "合同"),
    PRODUCT(6, "产品"),
    RECEIVABLE(7, "回款"),
    RECEIVABLE_PLAN(8, "回款计划")
    ;

    /**
     * 类型
     */
    private final Integer value;
    /**
     * 名称
     */
    private final String description;

}
