package org.dromara.edu.course.controller;

import java.util.List;

import cn.hutool.core.lang.tree.Tree;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.edu.course.service.ICategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.edu.course.domain.vo.CategoryVo;
import org.dromara.edu.course.domain.bo.CategoryBo;

/**
 * 课程分类管理
 *
 * @author gg
 * @date 2025-07-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/edu/courseCategory")
public class CategoryController extends BaseController {

    private final ICategoryService categoryService;
    /**
     * 获取部门树列表
     */
    @SaCheckPermission("edu:courseCategory:list")
    @GetMapping("/tree")
    public R<List<Tree<Long>>> cateTree(CategoryBo bo) {
        return R.ok(categoryService.selectCateTreeList(bo));
    }

    /**
     * 查询课程分类管理列表
     */
    @SaCheckPermission("edu:courseCategory:list")
    @GetMapping("/list")
    public R<List<CategoryVo>> list(CategoryBo bo) {
        List<CategoryVo> list = categoryService.queryList(bo);
        return R.ok(list);
    }

    /**
     * 导出课程分类管理列表
     */
    @SaCheckPermission("edu:courseCategory:export")
    @Log(title = "课程分类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CategoryBo bo, HttpServletResponse response) {
        List<CategoryVo> list = categoryService.queryList(bo);
        ExcelUtil.exportExcel(list, "课程分类管理", CategoryVo.class, response);
    }

    /**
     * 获取课程分类管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("edu:courseCategory:query")
    @GetMapping("/{id}")
    public R<CategoryVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(categoryService.queryById(id));
    }

    /**
     * 新增课程分类管理
     */
    @SaCheckPermission("edu:courseCategory:add")
    @Log(title = "课程分类管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CategoryBo bo) {
        return toAjax(categoryService.insertByBo(bo));
    }

    /**
     * 修改课程分类管理
     */
    @SaCheckPermission("edu:courseCategory:edit")
    @Log(title = "课程分类管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CategoryBo bo) {
        return toAjax(categoryService.updateByBo(bo));
    }

    /**
     * 删除课程分类管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("edu:courseCategory:remove")
    @Log(title = "课程分类管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(categoryService.deleteWithValidByIds(List.of(ids), true));
    }
}
