package org.dromara.generator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author GG 代码生成模式
 */

@AllArgsConstructor
@Getter
public enum TplCategory {
    /**
     *   单表（增删改查）
     */
    ONE(1,"crud"),
    /**
     *   树表（增删改查）
     */
    TREE(2,"tree"),
    /**
     *  主子表 - 主表 - 普通模式
     */
    MASTER_NORMAL(10,"master_normal"),
    /**
     * 主子表 - 主表 - ERP 模式
     */
    MASTER_ERP(11,"master_erp"),
    /**
     * 主子表 - 主表 - 内嵌模式
     */
    MASTER_INNER(12,"master_inner"),
    /**
     * 主子表 - 子表
     */
    SUB(15,"sub"), ;
    /**
     * 类型
     */
    private final Integer type;
    private final String code;
    /**
     * 是否为主表
     *
     * @param type 类型
     * @return 是否主表
     */
    public static boolean isMaster(Integer type) {
        return  MASTER_NORMAL.type.equals(type)|| MASTER_ERP.type.equals(type)|| MASTER_INNER.type.equals(type);
    }
    public static boolean isMaster(String code) {
        return  MASTER_NORMAL.code.equals(code)|| MASTER_ERP.code.equals(code)|| MASTER_INNER.code.equals(code);
    }
    public static boolean isCrud(Integer type) {
        return  ONE.type.equals(type);
    }
    public static boolean isCrud(String code) {
        return  ONE.code.equals(code);
    }
    public static boolean isTree(Integer type) {
        return  TREE.type.equals(type);
    }

    public static boolean isTree(String code) {
        return  TREE.code.equals(code);
    }
}
