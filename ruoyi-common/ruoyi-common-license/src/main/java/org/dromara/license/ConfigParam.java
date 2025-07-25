package org.dromara.license;

import lombok.Data;

@Data
public class ConfigParam {
    /**
     * 主题
     */
    private String subject;

    /**
     * 公钥别称
     */
    private String publicAlias;

    /**
     * 访问公钥库的密码
     */
    private String storePass;
}
