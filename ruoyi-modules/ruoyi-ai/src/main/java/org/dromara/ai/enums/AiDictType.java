package org.dromara.ai.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;


/**
 * AI 字典类型的枚举类
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum AiDictType implements BaseEnum<String> {

    /**
     * AI 写作格式
     */
    WRITE_FORMAT("write_format","写作格式"),
    /**
     * AI 写作长度
     */
    WRITE_LENGTH("write_length","写作长度"),
    /**
     * AI 写作语言
     */
    WRITE_LANGUAGE("write_language","写作语言"),
    /**
     * AI 写作语气
     */
    WRITE_TONE("write_tone","写作语气"),

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
