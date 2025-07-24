package org.dromara.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

import java.util.Objects;

/**
 * 支付订单的状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PayOrderStatus  implements BaseEnum<Integer> {

    WAITING(0, "未支付"),
    SUCCESS(10, "支付成功"),
    REFUND(20, "已退款"),
    /**
     * 注意：全部退款后，还是 REFUND 状态
     */
    CLOSED(30, "支付关闭"),
    ;

    private final Integer value;
    private final String description;


    /**
     * 判断是否等待支付
     *
     * @param status 状态
     * @return 是否等待支付
     */
    public static boolean isWaiting(Integer status) {
        return Objects.equals(status, WAITING.getValue());
    }

    /**
     * 判断是否支付成功
     *
     * @param status 状态
     * @return 是否支付成功
     */
    public static boolean isSuccess(Integer status) {
        return Objects.equals(status, SUCCESS.getValue());
    }

    /**
     * 判断是否已退款
     *
     * @param status 状态
     * @return 是否已退款
     */
    public static boolean isRefund(Integer status) {
        return Objects.equals(status, REFUND.getValue());
    }

    /**
     * 判断是否支付成功或者已退款
     *
     * @param status 状态
     * @return 是否支付成功或者已退款
     */
    public static boolean isSuccessOrRefund(Integer status) {
        return Objects.equals(status, SUCCESS.getValue()) || Objects.equals(status, REFUND.getValue());
    }

    /**
     * 判断是否支付关闭
     *
     * @param status 状态
     * @return 是否支付关闭
     */
    public static boolean isClosed(Integer status) {
        return Objects.equals(status, CLOSED.getValue());
    }

}
