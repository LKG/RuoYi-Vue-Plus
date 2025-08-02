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
import org.dromara.edu.course.domain.vo.CourseWareVo;
import org.dromara.edu.course.domain.bo.CourseWareBo;
import org.dromara.edu.course.service.ICourseWareService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 课件
 *
 * @author gg
 * @date 2025-07-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/edu/courseWare")
public class CourseWareController extends BaseController {

    private final ICourseWareService courseWareService;

    /**
     * 查询课件列表
     */
    @SaCheckPermission("edu:courseWare:list")
    @GetMapping("/list")
    public TableDataInfo<CourseWareVo> list(CourseWareBo bo, PageQuery pageQuery) {
        return courseWareService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出课件列表
     */
    @SaCheckPermission("edu:courseWare:export")
    @Log(title = "课件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CourseWareBo bo, HttpServletResponse response) {
        List<CourseWareVo> list = courseWareService.queryList(bo);
        ExcelUtil.exportExcel(list, "课件", CourseWareVo.class, response);
    }

    /**
     * 获取课件详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("edu:courseWare:query")
    @GetMapping("/{id}")
    public R<CourseWareVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(courseWareService.queryById(id));
    }

    /**
     * 新增课件
     */
    @SaCheckPermission("edu:courseWare:add")
    @Log(title = "课件", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CourseWareBo bo) {
        return toAjax(courseWareService.insertByBo(bo));
    }

    /**
     * 修改课件
     */
    @SaCheckPermission("edu:courseWare:edit")
    @Log(title = "课件", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CourseWareBo bo) {
        return toAjax(courseWareService.updateByBo(bo));
    }

    /**
     * 删除课件
     *
     * @param ids 主键串
     */
    @SaCheckPermission("edu:courseWare:remove")
    @Log(title = "课件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(courseWareService.deleteWithValidByIds(List.of(ids), true));
    }
}
