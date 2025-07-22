package org.dromara.common.core.enums;

import java.io.Serializable;
import java.util.Objects;

/**
 * 枚举接口
 *
 * @param <T> value 类型
 * @author gg
 * @since 1.0.0
 */
public interface BaseEnum<T extends Serializable> {

    /**
     * 枚举值
     *
     * @return 枚举值
     */
    T getValue();

    /**
     * 枚举描述
     *
     * @return 枚举描述
     */
    String getDescription();

    /**
     * 颜色
     *
     * @return 颜色
     */
    default String getColor() {
        return null;
    }
    /**
     * 根据枚举值获取
     *
     * @param value 枚举值
     * @param clazz 枚举类
     * @return 枚举对象
     * @since 2.8.1
     */
    static <E extends Enum<E> & BaseEnum<T>, T extends Serializable> E getByValue(T value, Class<E> clazz) {
        for (E e : clazz.getEnumConstants()) {
            if (Objects.equals(e.getValue(), value)) {
                return e;
            }
        }
        return null;
    }


    /**
     * 根据枚举描述获取
     *
     * @param description 枚举描述
     * @param clazz       枚举类
     * @return 枚举对象
     * @since 2.8.1
     */
    static <E extends Enum<E> & BaseEnum<T>, T extends Serializable> E getByDescription(String description, Class<E> clazz) {
        for (E e : clazz.getEnumConstants()) {
            if (Objects.equals(e.getDescription(), description)) {
                return e;
            }
        }
        return null;
    }
    /**
     * 判断枚举值是否有效
     *
     * @param value 枚举值
     * @param clazz 枚举类
     * @return 是否有效
     * @since 2.8.1
     */
    static <E extends Enum<E> & BaseEnum<T>, T extends Serializable> boolean isValidValue(T value, Class<E> clazz) {
        return getByValue(value, clazz) != null;
    }
}
