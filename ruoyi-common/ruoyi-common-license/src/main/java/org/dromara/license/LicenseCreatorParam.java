package org.dromara.license;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gg
 */
@Data
public class LicenseCreatorParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 证书主题
     */
    private String subject;

    /**
     * 私钥别称
     */
    private String privateAlias;


    /**
     * 访问公钥/私钥库的密码
     */
    private String storePwd;

    /**
     * 公钥/私钥的密码
     */
    private String keyPwd;

    /**
     * 证书生成路径
     */
    private String licensePath;

    /**
     * 私钥库存储路径
     */
    private String privateKeysStorePath;

    /**
     * 证书生效时间
     */
    private LocalDateTime issuedTime = LocalDateTime.now();

    /**
     * 证书失效时间
     */
    private LocalDateTime expiryTime;

    /**
     * 用户类型
     */
    private String consumerType = "user";

    /**
     * 用户数量
     */
    private Integer consumerAmount = 1;

    /**
     * 描述信息
     */
    private String description;
}
