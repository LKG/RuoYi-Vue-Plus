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
import org.dromara.edu.exam.qu.domain.vo.QuestionsVo;
import org.dromara.edu.exam.qu.domain.bo.QuestionsBo;
import org.dromara.edu.exam.qu.service.IQuestionsService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 题库
 *
 * @author gg
 * @date 2025-08-01
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/exam/questions")
public class QuestionsController extends BaseController {

    private final IQuestionsService questionsService;

    /**
     * 查询题库列表
     */
    @SaCheckPermission("exam:questions:list")
    @GetMapping("/list")
    public TableDataInfo<QuestionsVo> list(QuestionsBo bo, PageQuery pageQuery) {
        return questionsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出题库列表
     */
    @SaCheckPermission("exam:questions:export")
    @Log(title = "题库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(QuestionsBo bo, HttpServletResponse response) {
        List<QuestionsVo> list = questionsService.queryList(bo);
        ExcelUtil.exportExcel(list, "题库", QuestionsVo.class, response);
    }

    /**
     * 获取题库详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("exam:questions:query")
    @GetMapping("/{id}")
    public R<QuestionsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(questionsService.queryById(id));
    }

    /**
     * 新增题库
     */
    @SaCheckPermission("exam:questions:add")
    @Log(title = "题库", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody QuestionsBo bo) {
        return toAjax(questionsService.insertByBo(bo));
    }

    /**
     * 修改题库
     */
    @SaCheckPermission("exam:questions:edit")
    @Log(title = "题库", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody QuestionsBo bo) {
        return toAjax(questionsService.updateByBo(bo));
    }

    /**
     * 删除题库
     *
     * @param ids 主键串
     */
    @SaCheckPermission("exam:questions:remove")
    @Log(title = "题库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(questionsService.deleteWithValidByIds(List.of(ids), true));
    }
}
