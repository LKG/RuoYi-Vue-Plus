package org.dromara.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 渠道的退款状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PayRefundStatus {

    WAITING(0, "未退款"),
    SUCCESS(10, "退款成功"),
    FAILURE(20, "退款失败");

    private final Integer value;
    private final String name;

    public static boolean isSuccess(Integer status) {
        return Objects.equals(status, SUCCESS.getValue());
    }

    public static boolean isFailure(Integer status) {
        return Objects.equals(status, FAILURE.getValue());
    }

}
