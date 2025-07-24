package org.dromara.pay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * 支付 UI 展示模式
 *
 * @author gg
 */
@Getter
@AllArgsConstructor
public enum PayOrderDisplayMode implements BaseEnum<String> {
    /**
     * 跳转链接
     */
    URL("url","Redirect 跳转链接"),
    /**
     * IFrame内嵌
     */
    IFRAME("iframe"," IFrame内嵌链接"),
    /**
     * HTML 表单提交
     */
    FORM("form","HTML 表单提交"),
    /**
     * 二维码
     */
    QR_CODE("qr_code","文字二维码"),
    QR_CODE_URL("qr_code_url","二维码图片链接"),
    /**
     * 条形码
     */
    BAR_CODE("bar_code","条形码"),
    /**
     * APP 应用：Android、iOS、微信小程序、微信公众号等，需要做自定义处理的
     */
    APP("app",""),
    ;
    /**
     * 业务分类
     */
    private final String value;
    /**
     * 说明
     */
    private final String description;

}
