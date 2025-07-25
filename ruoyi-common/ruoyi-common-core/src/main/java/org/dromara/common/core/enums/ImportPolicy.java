package org.dromara.common.core.enums;

import cn.hutool.core.collection.CollUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author gg
 * 数据导入处理规则
 */

@Getter
@RequiredArgsConstructor
public enum ImportPolicy  implements BaseEnum<Integer>{
    /**
     * 跳过该行
     */
    SKIP(1, "跳过该行"),

    /**
     * 修改数据
     */
    UPDATE(2, "修改数据"),

    /**
     * 停止导入
     */
    EXIT(3, "停止导入");

    private final Integer value;
    private final String description;

    public boolean validate(ImportPolicy importPolicy, String data, List<String> existList) {
        return this == importPolicy && CollUtil.isNotEmpty(existList) && existList.contains(data);
    }
}
