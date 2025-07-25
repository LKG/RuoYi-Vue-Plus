package org.dromara.license.bean;

import de.schlichtherle.license.LicenseContent;
import de.schlichtherle.license.LicenseManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.license.LicenseVerifyProperties;
import org.dromara.license.exception.LicenseException;
import org.dromara.license.manager.CustomLicenseManager;

import java.io.File;
import java.nio.file.Paths;

@Slf4j
@AllArgsConstructor
public class LicenseInstallerBean {
    private final LicenseVerifyProperties properties;
    private LicenseManager licenseManager;

    /**
     * 安装许可证
     */
    public void installLicense() {
        try {
            this.licenseManager = CustomLicenseManager.getInstance(properties);
            licenseManager.uninstall();
            File licenseFile = Paths.get(properties.getStorePath(), "clientLicense", "license.lic").toFile();
            LicenseContent licenseContent = licenseManager.install(licenseFile);
            log.info("证书认证通过，安装成功: {}", licenseContent.getSubject());
        } catch (Exception e) {
//            throw new LicenseException("证书认证失败", e);
        }
    }

    /**
     * 卸载许可证
     */
    public void uninstallLicense() {
        if (licenseManager != null) {
            try {
                licenseManager.uninstall();
                log.info("证书已卸载");
            } catch (Exception e) {
                log.warn("卸载证书失败", e);
            }
        }
    }

    /**
     * 即时验证证书合法性
     */
    public void verify() {
        if (licenseManager != null) {
            try {
                licenseManager.verify();
                log.info("证书验证成功");
            } catch (Exception e) {
//                throw new LicenseException("证书认证失败", e);
            }
        } else {
//            throw new LicenseException("证书认证失败: licenseManager is null");
        }
    }

}
