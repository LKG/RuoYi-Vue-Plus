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
import org.dromara.edu.course.domain.vo.EduResourceVo;
import org.dromara.edu.course.domain.bo.EduResourceBo;
import org.dromara.edu.course.service.IEduResourceService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 资源
 *
 * @author gg
 * @date 2025-07-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/edu/resource")
public class EduResourceController extends BaseController {

    private final IEduResourceService eduResourceService;

    /**
     * 查询资源列表
     */
    @SaCheckPermission("course:resource:list")
    @GetMapping("/list")
    public TableDataInfo<EduResourceVo> list(EduResourceBo bo, PageQuery pageQuery) {
        return eduResourceService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出资源列表
     */
    @SaCheckPermission("course:resource:export")
    @Log(title = "资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(EduResourceBo bo, HttpServletResponse response) {
        List<EduResourceVo> list = eduResourceService.queryList(bo);
        ExcelUtil.exportExcel(list, "资源", EduResourceVo.class, response);
    }

    /**
     * 获取资源详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("course:resource:query")
    @GetMapping("/{id}")
    public R<EduResourceVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(eduResourceService.queryById(id));
    }

    /**
     * 新增资源
     */
    @SaCheckPermission("course:resource:add")
    @Log(title = "资源", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody EduResourceBo bo) {
        return toAjax(eduResourceService.insertByBo(bo));
    }

    /**
     * 修改资源
     */
    @SaCheckPermission("course:resource:edit")
    @Log(title = "资源", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody EduResourceBo bo) {
        return toAjax(eduResourceService.updateByBo(bo));
    }

    /**
     * 删除资源
     *
     * @param ids 主键串
     */
    @SaCheckPermission("course:resource:remove")
    @Log(title = "资源", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(eduResourceService.deleteWithValidByIds(List.of(ids), true));
    }
}
