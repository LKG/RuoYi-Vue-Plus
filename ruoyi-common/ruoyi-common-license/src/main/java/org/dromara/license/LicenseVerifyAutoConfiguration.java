package org.dromara.license;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * license 校验模块 自动配置
 *
 * @author loach
 * @since 2.12.0
 */
@AutoConfiguration
@EnableConfigurationProperties(LicenseVerifyProperties.class)
@ConditionalOnProperty(prefix = "", name = "", havingValue = "true", matchIfMissing = true)
public class LicenseVerifyAutoConfiguration {
}
