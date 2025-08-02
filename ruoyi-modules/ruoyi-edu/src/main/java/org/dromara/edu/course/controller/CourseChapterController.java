package org.dromara.edu.course.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.edu.course.domain.vo.CourseChapterVo;
import org.dromara.edu.course.domain.bo.CourseChapterBo;
import org.dromara.edu.course.service.ICourseChapterService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 课程章节
 *
 * @author gg
 * @date 2025-07-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/edu/courseChapter")
public class CourseChapterController extends BaseController {

    private final ICourseChapterService courseChapterService;

    /**
     * 查询课程章节列表
     */
    @SaCheckPermission("edu:courseChapter:list")
    @GetMapping("/list")
    public TableDataInfo<CourseChapterVo> list(CourseChapterBo bo, PageQuery pageQuery) {
        return courseChapterService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出课程章节列表
     */
    @SaCheckPermission("edu:courseChapter:export")
    @Log(title = "课程章节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CourseChapterBo bo, HttpServletResponse response) {
        List<CourseChapterVo> list = courseChapterService.queryList(bo);
        ExcelUtil.exportExcel(list, "课程章节", CourseChapterVo.class, response);
    }

    /**
     * 获取课程章节详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("edu:courseChapter:query")
    @GetMapping("/{id}")
    public R<CourseChapterVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(courseChapterService.queryById(id));
    }

    /**
     * 新增课程章节
     */
    @SaCheckPermission("edu:courseChapter:add")
    @Log(title = "课程章节", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CourseChapterBo bo) {
        return toAjax(courseChapterService.insertByBo(bo));
    }

    /**
     * 修改课程章节
     */
    @SaCheckPermission("edu:courseChapter:edit")
    @Log(title = "课程章节", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CourseChapterBo bo) {
        return toAjax(courseChapterService.updateByBo(bo));
    }

    /**
     * 删除课程章节
     *
     * @param ids 主键串
     */
    @SaCheckPermission("edu:courseChapter:remove")
    @Log(title = "课程章节", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(courseChapterService.deleteWithValidByIds(List.of(ids), true));
    }
}
