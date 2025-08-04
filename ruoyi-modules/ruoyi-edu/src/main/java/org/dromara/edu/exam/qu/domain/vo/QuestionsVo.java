package org.dromara.edu.exam.qu.domain.vo;

import org.dromara.edu.exam.qu.domain.Questions;
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
 * 题库视图对象 exam_questions
 *
 * @author gg
 * @date 2025-08-01
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Questions.class)
public class QuestionsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 题目
     */
    @ExcelProperty(value = "题目")
    private String title;

    /**
     * 题目类型：1.单选、2.多选、3.判断、4.简答、5.填空
     */
    @ExcelProperty(value = "题目类型：1.单选、2.多选、3.判断、4.简答、5.填空")
    private Integer questionsType;

    /**
     * 正确选项
     */
    @ExcelProperty(value = "正确选项")
    private String correctOptionKey;

    /**
     * 题目解析
     */
    @ExcelProperty(value = "题目解析")
    private String questionsAnalyze;

    /**
     * 分数
     */
    @ExcelProperty(value = "分数")
    private Long score;

    /**
     * 难度
     */
    @ExcelProperty(value = "难度")
    private String difficulty;

    /**
     * 数据来源
     */
    @ExcelProperty(value = "数据来源")
    private Long sourceType;

    /**
     * 课程id
     */
    @ExcelProperty(value = "课程id")
    private Long courseId;

    /**
     * 分类id
     */
    @ExcelProperty(value = "分类id")
    private Long categoryId;


}
