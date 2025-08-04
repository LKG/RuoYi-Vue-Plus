package org.dromara.edu.exam.qu.domain.vo;

import org.dromara.edu.exam.qu.domain.QuestionsOptions;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 题库选项视图对象 exam_questions_options
 *
 * @author gg
 * @date 2025-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = QuestionsOptions.class)
public class QuestionsOptionsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 题库ID
     */
    @ExcelProperty(value = "题库ID")
    private Long questionsId;

    /**
     * 选项名
     */
    @ExcelProperty(value = "选项名")
    private String optionName;

    /**
     * 分数
     */
    @ExcelProperty(value = "分数")
    private Long score;

    /**
     * 答案
     */
    @ExcelProperty(value = "答案")
    private String answer;

    /**
     * 排序字段
     */
    @ExcelProperty(value = "排序字段")
    private Integer sortNum;

    /**
     * 选项key
     */
    @ExcelProperty(value = "选项key")
    private String optionKey;


}
