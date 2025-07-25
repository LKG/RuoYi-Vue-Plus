package org.dromara.license;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gg
 * 创建License参数
 */
@Data
public class LicenseCreatorParamVO {
    /**
     * 有效期截至时间
     */
    private LocalDateTime expireTime;

    /**
     * 客户名称
     */
    private String customerName;


    /**
     * 访问公钥/私钥库的密码
     */
    private String storePwd;

    /**
     * 公钥/私钥的密码
     */
    private String keyPwd;

    /**
     * 描述信息
     */
    private String description;

    /**
     * license 保存位置
     */
    private String licenseSavePath;

    /**
     * 额外的服务器硬件校验信息
     */
    private LicenseExtraModel licenseExtraModel;
}
