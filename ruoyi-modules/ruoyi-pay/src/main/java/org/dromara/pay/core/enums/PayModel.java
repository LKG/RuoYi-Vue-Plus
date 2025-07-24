package org.dromara.pay.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * 支付模式枚举
 * @author gg
 */
@Getter
@AllArgsConstructor
public enum PayModel  implements BaseEnum<String> {
    /**
     * 商户模式
     */
    BUSINESS_MODEL("BUSINESS_MODEL","商户模式"),
    /**
     * 服务商模式
     */
    SERVICE_MODE("SERVICE_MODE","服务商模式");
    /**
     * 业务分类
     */
    private final String value;
    /**
     * 说明
     */
    private final String description;
}
