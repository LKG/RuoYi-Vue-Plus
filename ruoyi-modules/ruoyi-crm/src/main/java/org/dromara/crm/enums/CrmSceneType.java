package org.dromara.crm.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * CRM 列表检索场景
 *
 * @author HUIHUI
 */
@Getter
@AllArgsConstructor
public enum CrmSceneType  implements BaseEnum<Integer> {

    OWNER(1, "我负责的"),
    INVOLVED(2, "我参与的"),
    SUBORDINATE(3, "下属负责的");

    /**
     * 场景类型
     */
    private final Integer value;
    /**
     * 场景名称
     */
    private final String description;

    /**
     * 判断是否是负责人
     * @param type 场景类型
     * @return boolean
     */
    public static boolean isOwner(Integer type) {
        return ObjUtil.equal(OWNER.getValue(), type);
    }
    /**
     * 判断是否是我参与的
     * @param type 场景类型
     * @return boolean
     */
    public static boolean isInvolved(Integer type) {
        return ObjUtil.equal(INVOLVED.getValue(), type);
    }
    /**
     * 判断是否下属负责的
     * @param type 场景类型
     * @return boolean
     */
    public static boolean isSubordinate(Integer type) {
        return ObjUtil.equal(SUBORDINATE.getValue(), type);
    }



}
