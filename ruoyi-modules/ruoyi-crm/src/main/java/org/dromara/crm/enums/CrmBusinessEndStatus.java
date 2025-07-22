package org.dromara.crm.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;

/**
 * 商机的结束状态枚举
 *
 * @author GG
 */
@RequiredArgsConstructor
@Getter
public enum CrmBusinessEndStatus implements BaseEnum<String> {

    WIN(1, "赢单"),
    LOSE(2, "输单"),
    INVALID(3, "无效");
    /**
     * 状态
     */
    private final Integer value;
    /**
     * 状态描述CrmPermissionLevelEnum.java
     */
    private final String description;

}
