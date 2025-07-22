package org.dromara.crm.enums;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * CRM 数据权限级别枚举
 * OWNER > WRITE > READ
 *
 * @author gg
 */
@Getter
@AllArgsConstructor
public enum CrmPermissionLevel  implements BaseEnum<Integer> {

    OWNER(1, "负责人"),
    READ(2, "只读"),
    WRITE(3, "读写"),

    ;

    /**
     * 权限等级
     */
    private final Integer value;
    /**
     * 权限等级描述
     */
    private final String description;


    public static boolean isOwner(Integer level) {
        return ObjUtil.equal(OWNER.value, level);
    }

    public static boolean isRead(Integer level) {
        return ObjUtil.equal(READ.value, level);
    }

    public static boolean isWrite(Integer level) {
        return ObjUtil.equal(WRITE.value, level);
    }

    public static String getDescriptionByLevel(Integer level) {
        CrmPermissionLevel typeEnum = CollUtil.findOne(CollUtil.newArrayList(CrmPermissionLevel.values()),
                item -> ObjUtil.equal(item.value, level));
        return typeEnum == null ? null : typeEnum.getDescription();
    }

}
