package org.dromara.pay.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;


/**
 * pay 字典类型的枚举类
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum PayDictType implements BaseEnum<String> {

    /**
     * pay 支付渠道编码
     */
    CHANNEL_CODE("pay_channel_code","支付渠道编码"),
    /**
     * pay 支付状态
     */
    ORDER_STATUS("pay_order_status","支付状态"),
    /**
     * pay 退款状态
     */
    REFUND_STATUS("pay_order_status","退款状态"),
    /**
     * pay 回调状态
     */
    NOTIFY_STATUS("pay_notify_status","回调状态"),

    /**
     * pay 转账状态
     */
    TRANSFER_STATUS("pay_transfer_status","转账状态"),
    ;
    /**
     * 字典code值
     */
    private final String value;
    /**
     * 描述
     */
    private final String description;


}
