package org.dromara.pay.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付系统异常 Exception
 * @author gg
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PayClientException extends RuntimeException {

    public PayClientException(Throwable cause) {
        super(cause);
    }

}
