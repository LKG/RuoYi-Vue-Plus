package org.dromara.edu.course.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.edu.course.domain.bo.CourseBo;
import org.dromara.edu.course.domain.vo.CourseVo;
import org.dromara.edu.course.service.ICourseService;
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
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 课程信息
 *
 * @author GG
 * @date 2025-07-24
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/edu/course")
public class CourseController extends BaseController {

    private final ICourseService courseService;

    /**
     * 查询课程信息列表
     */
    @SaCheckPermission("edu:course:list")
    @GetMapping("/list")
    public TableDataInfo<CourseVo> list(CourseBo bo, PageQuery pageQuery) {
        return courseService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出课程信息列表
     */
    @SaCheckPermission("edu:course:export")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CourseBo bo, HttpServletResponse response) {
        List<CourseVo> list = courseService.queryList(bo);
        ExcelUtil.exportExcel(list, "课程信息", CourseVo.class, response);
    }

    /**
     * 获取课程信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("edu:course:query")
    @GetMapping("/{id}")
    public R<CourseVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(courseService.queryById(id));
    }

    /**
     * 新增课程信息
     */
    @SaCheckPermission("edu:course:add")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CourseBo bo) {
        return toAjax(courseService.insertByBo(bo));
    }

    /**
     * 修改课程信息
     */
    @SaCheckPermission("edu:course:edit")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CourseBo bo) {
        return toAjax(courseService.updateByBo(bo));
    }

    /**
     * 删除课程信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("edu:course:remove")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(courseService.deleteWithValidByIds(List.of(ids), true));
    }
}
