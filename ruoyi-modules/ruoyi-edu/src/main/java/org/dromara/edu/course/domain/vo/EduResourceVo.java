package org.dromara.edu.course.domain.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.translation.annotation.Translation;
import org.dromara.common.translation.constant.TransConstant;
import org.dromara.edu.course.domain.EduResource;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 资源视图对象 edu_resource
 *
 * @author gg
 * @date 2025-07-30
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = EduResource.class)
public class EduResourceVo implements Serializable {

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
     * 封面
     */
    @ExcelProperty(value = "封面")
    private String coverUrl;

    @Translation(type = TransConstant.OSS_ID_TO_URL,mapper="coverUrl")
    private String coverOssUrl;
    /**
     * 文件地址
     */
    @ExcelProperty(value = "文件地址")
    private String fileUrl;

    @Translation(type = TransConstant.OSS_ID_TO_URL,mapper="fileUrl")
    private String fileOssUrl;

    /**
     * 分类id
     */
    @ExcelProperty(value = "分类名称")
    private Long categoryId;
    @Translation(type = "category_id_to_name",mapper="categoryId")
    private String categoryName;
    /**
     * 资源类型
     */
    @ExcelProperty(value = "资源类型")
    private Long type;

    /**
     * 课程状态
     */
    @ExcelProperty(value = "课程状态")
    private Long checkStatus;

    /**
     * 所属标签
     */
    @ExcelProperty(value = "所属标签")
    private String tagIds;

    /**
     * 资源描述
     */
    @ExcelProperty(value = "资源描述")
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
     * 是否发布
     */
    @ExcelProperty(value = "是否发布")
    private Long isPublished;

    /**
     * 发布时间
     */
    @ExcelProperty(value = "发布时间")
    private Date publishTime;


}
