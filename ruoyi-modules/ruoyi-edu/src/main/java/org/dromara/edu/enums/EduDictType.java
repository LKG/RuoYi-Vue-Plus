package org.dromara.edu.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;
import org.dromara.edu.EduConstants;


/**
 * edu 字典类型的枚举类
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum EduDictType implements BaseEnum<String>, EduConstants{


    /**
     * 试卷 考题状态
     */
    CUSTOMER_INDUSTRY("paper_qu_status","考题状态"),
    ;
    private final String value;
    private final String description;


}
