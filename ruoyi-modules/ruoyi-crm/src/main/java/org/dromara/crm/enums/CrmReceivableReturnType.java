package org.dromara.crm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * CRM 回款方式枚举
 *
 * @author gg
 */
@Getter
@AllArgsConstructor
public enum CrmReceivableReturnType  implements BaseEnum<Integer> {

    CHECK(1, "支票"),
    CASH(2, "现金"),
    POSTAL_REMITTANCE(3, "邮政汇款"),
    TELEGRAPHIC_TRANSFER(4, "电汇"),
    ONLINE_TRANSFER(5, "网上转账"),
    ALIPAY(6, "支付宝"),
    WECHAT_PAY(7, "微信支付"),
    OTHER(8, "其它");

    /**
     * 回款方式值
     */
    private final Integer value;
    /**
     * 回款方式描述
     */
    private final String description;
}
