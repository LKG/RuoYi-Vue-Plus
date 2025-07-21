package org.dromara.common.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 课程类型
 *
 * @author gg
 */
@Getter
@RequiredArgsConstructor
public enum CourseType implements BaseEnum<Integer> {

    /**
     * 视频
     */
    VIDEO(1,"视频"),


    /**
     * 音频
     */
    AUDIO(2, "音频"),
    DOC(3,"文档"),
    IMAGE(4, "图片"),
    ;

    private final Integer value;
    private final String description;
}
