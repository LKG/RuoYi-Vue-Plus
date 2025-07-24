package org.dromara.generator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dromara.common.core.enums.BaseEnum;

/**
 * @author GG 代码生成模式
 */

@AllArgsConstructor
@Getter
public enum TplCategory implements BaseEnum< Integer> {
    /**
     *   单表（增删改查）
     */
    ONE(1,"crud","单表（增删改查）"),
    /**
     *   树表（增删改查）
     */
    TREE(2,"tree","树表（增删改查）"),
    /**
     *  主子表 - 主表 - 普通模式
     */
    MASTER_NORMAL(10,"master_normal","主子表（主表-普通模式）"),
    /**
     * 主子表 - 主表 - ERP 模式
     */
    MASTER_ERP(11,"master_erp","主子表（主表-ERP模式）"),
    /**
     * 主子表 - 主表 - 内嵌模式
     */
    MASTER_INNER(12,"master_inner","主子表（主表-内嵌模式）"),
    /**
     * 主子表 - 子表
     */
    SUB(15,"sub","主子表（子表）"), ;
    /**
     * 类型
     */
    private final Integer value;
    private final String code;
    private final String description;
    /**
     * 是否为主表
     *
     * @param type 类型
     * @return 是否主表
     */
    public static boolean isMaster(Integer type) {
        return  MASTER_NORMAL.value.equals(type)|| MASTER_ERP.value.equals(type)|| MASTER_INNER.value.equals(type);
    }
    /**
     * 是否为主表
     *
     * @param code 编码
     * @return 是否主表
     */
    public static boolean isMaster(String code) {
        return  MASTER_NORMAL.code.equals(code)|| MASTER_ERP.code.equals(code)|| MASTER_INNER.code.equals(code);
    }
    /**
     * 是否为子表
     *
     * @param type 类型
     * @return 是否为子表
     */
    public static boolean isSub(Integer type) {
        return  SUB.value.equals(type);
    }
    /**
     * 是否为子表
     *
     * @param code 编码
     * @return 是否为子表
     */
    public static boolean isSub(String code) {
        return  SUB.code.equals(code);
    }
    /**
     * 是否单表
     *
     * @param type 类型
     * @return 是否单表
     */
    public static boolean isCrud(Integer type) {
        return  ONE.value.equals(type);
    }
    /**
     * 是否单表
     *
     * @param code 编码
     * @return 是否单表
     */
    public static boolean isCrud(String code) {
        return  ONE.code.equals(code);
    }
    /**
     * 是否树表
     *
     * @param type 类型
     * @return 是否树表
     */
    public static boolean isTree(Integer type) {
        return  TREE.value.equals(type);
    }
    /**
     * 是否树表
     *
     * @param code 编码
     * @return 是否树表
     */
    public static boolean isTree(String code) {
        return  TREE.code.equals(code);
    }
}
