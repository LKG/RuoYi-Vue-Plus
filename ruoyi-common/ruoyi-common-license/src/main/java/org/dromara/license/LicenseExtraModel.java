package org.dromara.license;

import lombok.Data;

import java.util.Set;

/**
 * @author gg
 * 额外扩展信息
 */
@Data
public class LicenseExtraModel {
    /**
     * 可被允许的IP地址
     */
    private Set<String> ipAddress;

    /**
     * 可被允许的mac地址
     */
    private Set<String> macAddress;

    /**
     * 可被允许的CPU序列号
     */
    private String cpuSerial;

    /**
     * 可被允许的主板序列号
     */
    private String mainBoardSerial;

}
