package org.dromara.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * 钱包交易业务分类
 *
 * @author gg
 */
@AllArgsConstructor
@Getter
public enum PayWalletBizType  implements BaseEnum<Integer> {

    RECHARGE(1, "充值"),
    RECHARGE_REFUND(2, "充值退款"),
    PAYMENT(3, "支付"),
    PAYMENT_REFUND(4, "支付退款"),
    UPDATE_BALANCE(5, "更新余额"),
    TRANSFER(6, "转账");

    /**
     * 业务分类
     */
    private final Integer value;
    /**
     * 说明
     */
    private final String description;

}
