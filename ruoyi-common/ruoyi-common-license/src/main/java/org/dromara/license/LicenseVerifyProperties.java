package org.dromara.license;

import cn.hutool.core.io.FileUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("1")
@Data
public class LicenseVerifyProperties {
    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * 生成的license文件所在路径
     */
    private String storePath = FileUtil.getTmpDirPath();
}
