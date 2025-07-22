package org.dromara.crm.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;


/**
 * CRM 字典类型的枚举类
 *
 * @author 芋道源码
 */
@Getter
@RequiredArgsConstructor
public enum CrmDictType implements BaseEnum<String> {


    /**
     * CRM 客户所属行业
     */
    CUSTOMER_INDUSTRY("customer_industry","客户所属行业"),
    /**
     * CRM 客户等级
     */
    CUSTOMER_LEVEL("customer_level","客户等级"),
    /**
     * CRM 客户来源
     */
    CUSTOMER_SOURCE("customer_source","客户来源"),
    /**
     * CRM 审批状态
     */
    AUDIT_STATUS("audit_status","审批状态"),
    /**
     * CRM 产品单位
     */
    PRODUCT_UNIT("product_unit","产品单位"),
    /**
     * CRM 产品状态
     */
    PRODUCT_STATUS("product_status","产品状态"),
    /**
     * CRM 跟进方式
     */
    FOLLOW_UP_TYPE("follow_up_type","跟进方式"),
    /**
     * CRM 回款方式
     */
    RECEIVABLE_RETURN_TYPE("receivable_return_type","回款方式"),
    ;
    private final String value;
    private final String description;


}
