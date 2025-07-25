package org.dromara.license.manager;

import de.schlichtherle.license.*;
import de.schlichtherle.xml.GenericCertificate;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.dromara.license.ConfigParam;
import org.dromara.license.CustomKeyStoreParam;
import org.dromara.license.LicenseExtraModel;
import org.dromara.license.LicenseVerifyProperties;
import org.dromara.license.bean.LicenseInstallerBean;
import org.dromara.license.exception.LicenseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.prefs.Preferences;

@Slf4j
public class CustomLicenseManager  extends LicenseManager {

    private static volatile CustomLicenseManager INSTANCE;
    private LicenseExtraModel extraModel;

    private final LicenseVerifyProperties properties;

    private CustomLicenseManager(LicenseVerifyProperties properties) {
        this.properties = properties;
        // 初始化服务信息
        initServerExtraModel();
        // 解压证书和配置文件等
        extractZip();
        // 获取配置文件
        ConfigParam configParam = getConfigParam();
        // 安装证书
        Preferences preferences = Preferences.userNodeForPackage(LicenseInstallerBean.class);
        CipherParam cipherParam = new DefaultCipherParam(configParam.getStorePass());
        KeyStoreParam publicKeyStoreParam = new CustomKeyStoreParam(LicenseInstallerBean.class, properties
            .getStorePath() + File.separator + "clientLicense/publicCerts.keystore", configParam
            .getPublicAlias(), configParam.getStorePass(), null);
        LicenseParam licenseParam = new DefaultLicenseParam(configParam
            .getSubject(), preferences, publicKeyStoreParam, cipherParam);

        super.setLicenseParam(licenseParam);
    }

    public static CustomLicenseManager getInstance(LicenseVerifyProperties properties) {
        if (INSTANCE == null) {
            synchronized (CustomLicenseManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CustomLicenseManager(properties);
                }
            }
        }
        return INSTANCE;
    }

    private void initServerExtraModel() {
//        this.extraModel = ServerInfoUtils.getServerInfos();
    }

    /**
     * 解压压缩包
     */
    private void extractZip() {
        Path zipPath = Paths.get(properties.getStorePath(), "clientLicense.zip");
        Path outputDir = Paths.get(properties.getStorePath(), "clientLicense");

        try (ZipFile zipFile = new ZipFile(zipPath.toFile())) {
            if (!Files.exists(outputDir)) {
                Files.createDirectories(outputDir);
            }
            zipFile.extractAll(outputDir.toAbsolutePath().toString());
        } catch (IOException e) {
            log.error("解压 clientLicense.zip 出错: {}", e.getMessage(), e);
//            throw new LicenseException("解压失败", e);
        }
    }

    /**
     * 获取压缩文件中配置的基础参数
     *
     * @return {@link ConfigParam }
     */
    private ConfigParam getConfigParam() {
        Path configPath = Paths.get(properties.getStorePath(), "clientLicense", "clientConfig.json");

        if (!Files.exists(configPath)) {
            log.warn("配置文件不存在: {}", configPath);
            return null;
        }

        try (InputStream inputStream = Files.newInputStream(configPath)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, ConfigParam.class);
        } catch (IOException e) {
            log.error("读取配置文件失败: {}", e.getMessage(), e);
            return null;
        }
    }

    /**
     * 重写验证证书方法，添加自定义参数验证
     *
     * @param content 内容
     * @throws LicenseContentException 许可证内容例外
     */
    @Override
    protected synchronized void validate(LicenseContent content) throws LicenseContentException {
        // 系统验证基本参数：生效时间、失效时间、公钥别名、公钥密码
        super.validate(content);
        // 验证自定义参数
        Object o = content.getExtra();
        if (extraModel != null && o instanceof LicenseExtraModel contentExtraModel) {
            if (!contentExtraModel.getCpuSerial().equals(extraModel.getCpuSerial())) {
//                throw new LicenseException("CPU核数不匹配");
            }
            if (!contentExtraModel.getMainBoardSerial().equals(extraModel.getMainBoardSerial())) {
//                throw new LicenseException("主板序列号不匹配");
            }
            if (!contentExtraModel.getIpAddress().equals(extraModel.getIpAddress())) {
//                throw new LicenseException("IP地址不匹配");
            }
            if (!contentExtraModel.getMacAddress().equals(extraModel.getMacAddress())) {
//                throw new LicenseException("MAC地址不匹配");
            }
        } else {
//            throw new LicenseException("证书无效");
        }
    }

    /**
     * 重写证书安装方法，主要是更改调用本类的验证方法
     *
     * @param key    钥匙
     * @param notary 公证人
     * @return {@link LicenseContent }
     * @throws Exception 例外
     */
    @Override
    protected synchronized LicenseContent install(final byte[] key, LicenseNotary notary) throws Exception {

        final GenericCertificate certificate = getPrivacyGuard().key2cert(key);
        notary.verify(certificate);
        final LicenseContent content = (LicenseContent)certificate.getContent();
        this.validate(content);
        setLicenseKey(key);
        setCertificate(certificate);

        return content;
    }

    /**
     * 重写验证证书合法的方法，主要是更改调用本类的验证方法
     *
     * @param notary 公证人
     * @return {@link LicenseContent }
     * @throws Exception 例外
     */
    @Override
    protected synchronized LicenseContent verify(LicenseNotary notary) throws Exception {
        GenericCertificate certificate = getCertificate();
        if (certificate != null) {
            return (LicenseContent)certificate.getContent();
        }
        byte[] licenseKey = getLicenseKey();
        if (licenseKey == null) {
            String subject = getLicenseParam().getSubject();
            throw new NoLicenseInstalledException(subject);
        }
        // 使用私钥解密生成证书
        certificate = getPrivacyGuard().key2cert(licenseKey);
        // 验证证书签名
        notary.verify(certificate);
        // 提取内容并进行业务校验
        LicenseContent content = (LicenseContent)certificate.getContent();
        this.validate(content);
        // 缓存证书
        setCertificate(certificate);
        return content;
    }
}
