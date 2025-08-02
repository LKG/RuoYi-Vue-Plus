package org.dromara.edu.exam.qu.controller;

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
import org.dromara.edu.exam.qu.domain.vo.QuestionsOptionsVo;
import org.dromara.edu.exam.qu.domain.bo.QuestionsOptionsBo;
import org.dromara.edu.exam.qu.service.IQuestionsOptionsService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 题库选项
 *
 * @author gg
 * @date 2025-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/exam/questionsOptions")
public class QuestionsOptionsController extends BaseController {

    private final IQuestionsOptionsService questionsOptionsService;

    /**
     * 查询题库选项列表
     */
    @SaCheckPermission("exam:questionsOptions:list")
    @GetMapping("/list")
    public TableDataInfo<QuestionsOptionsVo> list(QuestionsOptionsBo bo, PageQuery pageQuery) {
        return questionsOptionsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出题库选项列表
     */
    @SaCheckPermission("exam:questionsOptions:export")
    @Log(title = "题库选项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(QuestionsOptionsBo bo, HttpServletResponse response) {
        List<QuestionsOptionsVo> list = questionsOptionsService.queryList(bo);
        ExcelUtil.exportExcel(list, "题库选项", QuestionsOptionsVo.class, response);
    }

    /**
     * 获取题库选项详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("exam:questionsOptions:query")
    @GetMapping("/{id}")
    public R<QuestionsOptionsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(questionsOptionsService.queryById(id));
    }

    /**
     * 新增题库选项
     */
    @SaCheckPermission("exam:questionsOptions:add")
    @Log(title = "题库选项", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody QuestionsOptionsBo bo) {
        return toAjax(questionsOptionsService.insertByBo(bo));
    }

    /**
     * 修改题库选项
     */
    @SaCheckPermission("exam:questionsOptions:edit")
    @Log(title = "题库选项", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody QuestionsOptionsBo bo) {
        return toAjax(questionsOptionsService.updateByBo(bo));
    }

    /**
     * 删除题库选项
     *
     * @param ids 主键串
     */
    @SaCheckPermission("exam:questionsOptions:remove")
    @Log(title = "题库选项", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(questionsOptionsService.deleteWithValidByIds(List.of(ids), true));
    }
}
