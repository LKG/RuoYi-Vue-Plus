package org.dromara.license;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;
import net.lingala.zip4j.ZipFile;

/**
 * @author gg
 * 构建创建者响应
 */
@Data
public class BuildCreatorResp implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 许可证创建者参数
     */
    private LicenseCreatorParam param;

    /**
     * 客户端 Zip 文件
     */
    private ZipFile clientZipFile;
}
