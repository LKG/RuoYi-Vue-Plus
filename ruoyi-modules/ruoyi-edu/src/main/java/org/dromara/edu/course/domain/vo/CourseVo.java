package org.dromara.edu.course.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.common.translation.annotation.Translation;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.edu.course.domain.Course;
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
 * 课程信息视图对象 edu_course
 *
 * @author GG
 * @date 2025-07-24
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Course.class)
public class CourseVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    private String title;

    /**
     * 是否推荐
     */
    @ExcelProperty(value = "是否推荐")
    private Integer isRecommend;

    /**
     * 是否置顶
     */
    @ExcelProperty(value = "是否置顶")
    private Integer isTop;

    /**
     * 是否必修课
     */
    @ExcelProperty(value = "是否必修课")
    private Integer isRequired;

    /**
     * 课程封面
     */
    @ExcelProperty(value = "课程封面")
    private String coverUrl;
    @Translation(type = TransConstant.OSS_ID_TO_URL,mapper="coverUrl")
    private String coverOssUrl;
    /**
     * 分类id
     */
    @ExcelProperty(value = "分类id")
    private Long categoryId;
    @Translation(type = "category_id_to_name",mapper="categoryId")
    private String categoryName;
    /**
     * 课程类型
     */
    @ExcelProperty(value = "课程类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "edu_course_type")
    private Integer type;

    /**
     * 审核状态
     */
    @ExcelProperty(value = "审核状态")
    private Integer checkStatus;

    /**
     * 所属标签
     */
    @ExcelProperty(value = "所属标签")
    private String tagIds;

    /**
     * 课程描述
     */
    @ExcelProperty(value = "课程描述")
    private String description;

    /**
     * 收藏量
     */
    @ExcelProperty(value = "收藏量")
    private Long collectCount;

    /**
     * 阅读量
     */
    @ExcelProperty(value = "阅读量")
    private Long viewCount;

    /**
     * 课程来源
     */
    @ExcelProperty(value = "课程来源")
    private Integer sourceType;

    /**
     * 是否发布
     */
    @ExcelProperty(value = "是否发布")
    private Integer isPublished;

    /**
     * 是否精品
     */
    @ExcelProperty(value = "是否精品")
    private Integer isPremium;

    /**
     * 发布时间
     */
    @ExcelProperty(value = "发布时间")
    private Date publishTime;

    /**
     * 通知范围（0：所有人；1：指定部门;2：指定用户）
     */
    @ExcelProperty(value = "通知范围", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "notice_scope")
    private Integer noticeScope;

    /**
     * 通知用户/部门
     */
    @ExcelProperty(value = "通知用户/部门")
    private String noticeUsers;

}
