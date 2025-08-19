package org.dromara.edu.exam.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.enums.BaseEnum;
import org.dromara.edu.ExamConstants;


/**
 * edu 字典类型的枚举类
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum ExamDictType implements BaseEnum<String> , ExamConstants {


    /**
     * 试卷 考题状态
     */
    PAPER_QU_STATUS(DICT_PREFIX+"paper_qu_status","考题状态"),
    PAPER_TYPE(DICT_PREFIX+"paper_type","试卷类型"),
    PAPER_RECORD_STATUS(DICT_PREFIX+"paper_record_status","答卷状态"),
    QU_SOURCE_TYPE(DICT_PREFIX+"qu_source_type","试题来源"),
    QU_TYPE(DICT_PREFIX+"qu_type","考题类型"),

    ;
    private final String value;
    private final String description;


}
