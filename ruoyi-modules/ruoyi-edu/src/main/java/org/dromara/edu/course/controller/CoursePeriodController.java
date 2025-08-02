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
import org.dromara.edu.course.domain.vo.CoursePeriodVo;
import org.dromara.edu.course.domain.bo.CoursePeriodBo;
import org.dromara.edu.course.service.ICoursePeriodService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 课时
 *
 * @author gg
 * @date 2025-07-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/edu/coursePeriod")
public class CoursePeriodController extends BaseController {

    private final ICoursePeriodService coursePeriodService;

    /**
     * 查询课时列表
     */
    @SaCheckPermission("edu:coursePeriod:list")
    @GetMapping("/list")
    public TableDataInfo<CoursePeriodVo> list(CoursePeriodBo bo, PageQuery pageQuery) {
        return coursePeriodService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出课时列表
     */
    @SaCheckPermission("edu:coursePeriod:export")
    @Log(title = "课时", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CoursePeriodBo bo, HttpServletResponse response) {
        List<CoursePeriodVo> list = coursePeriodService.queryList(bo);
        ExcelUtil.exportExcel(list, "课时", CoursePeriodVo.class, response);
    }

    /**
     * 获取课时详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("edu:coursePeriod:query")
    @GetMapping("/{id}")
    public R<CoursePeriodVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(coursePeriodService.queryById(id));
    }

    /**
     * 新增课时
     */
    @SaCheckPermission("edu:coursePeriod:add")
    @Log(title = "课时", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CoursePeriodBo bo) {
        return toAjax(coursePeriodService.insertByBo(bo));
    }

    /**
     * 修改课时
     */
    @SaCheckPermission("edu:coursePeriod:edit")
    @Log(title = "课时", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CoursePeriodBo bo) {
        return toAjax(coursePeriodService.updateByBo(bo));
    }

    /**
     * 删除课时
     *
     * @param ids 主键串
     */
    @SaCheckPermission("edu:coursePeriod:remove")
    @Log(title = "课时", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(coursePeriodService.deleteWithValidByIds(List.of(ids), true));
    }
}
