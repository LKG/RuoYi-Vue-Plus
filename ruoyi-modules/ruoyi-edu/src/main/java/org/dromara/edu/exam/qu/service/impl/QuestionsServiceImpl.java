package org.dromara.edu.exam.qu.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.edu.exam.qu.domain.bo.QuestionsOptionsBo;
import org.dromara.edu.exam.qu.enums.QuType;
import org.dromara.edu.exam.qu.service.IQuestionsOptionsService;
import org.springframework.stereotype.Service;
import org.dromara.edu.exam.qu.domain.bo.QuestionsBo;
import org.dromara.edu.exam.qu.domain.vo.QuestionsVo;
import org.dromara.edu.exam.qu.domain.Questions;
import org.dromara.edu.exam.qu.mapper.QuestionsMapper;
import org.dromara.edu.exam.qu.service.IQuestionsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 题库Service业务层处理
 *
 * @author gg
 * @date 2025-08-01
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionsServiceImpl implements IQuestionsService {

    private final QuestionsMapper baseMapper;

    private final IQuestionsOptionsService questionsOptionsService;

    /**
     * 查询题库
     *
     * @param id 主键
     * @return 题库
     */
    @Override
    public QuestionsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询题库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 题库分页列表
     */
    @Override
    public TableDataInfo<QuestionsVo> queryPageList(QuestionsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Questions> lqw = buildQueryWrapper(bo);
        Page<QuestionsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的题库列表
     *
     * @param bo 查询条件
     * @return 题库列表
     */
    @Override
    public List<QuestionsVo> queryList(QuestionsBo bo) {
        LambdaQueryWrapper<Questions> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Questions> buildQueryWrapper(QuestionsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Questions> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(Questions::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), Questions::getTitle, bo.getTitle());
        lqw.eq(bo.getQuestionsType() != null, Questions::getQuestionsType, bo.getQuestionsType());
        lqw.eq(StringUtils.isNotBlank(bo.getCorrectOptionKey()), Questions::getCorrectOptionKey, bo.getCorrectOptionKey());
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionsAnalyze()), Questions::getQuestionsAnalyze, bo.getQuestionsAnalyze());
        lqw.eq(bo.getScore() != null, Questions::getScore, bo.getScore());
        lqw.eq(StringUtils.isNotBlank(bo.getDifficulty()), Questions::getDifficulty, bo.getDifficulty());
        lqw.eq(bo.getSourceType() != null, Questions::getSourceType, bo.getSourceType());
        lqw.eq(bo.getCourseId() != null, Questions::getCourseId, bo.getCourseId());
        lqw.eq(bo.getCategoryId() != null, Questions::getCategoryId, bo.getCategoryId());
        return lqw;
    }
    private void addOptions(Long id, List<QuestionsOptionsBo> optionsList, Integer questionsType, String correctOptionKey) {
        AtomicInteger optionsCount = new AtomicInteger(0);
        if(CollectionUtil.isEmpty(optionsList)){
            return;
        }
        for (QuestionsOptionsBo options : optionsList) {
            options.setQuestionsId(id);
            options.setSortNum(optionsCount.incrementAndGet());
            if(QuType.RADIO.getValue().equals(questionsType)&& correctOptionKey.equals(options.getOptionKey())){
                options.setAnswer(options.getOptionKey());
            }
            questionsOptionsService.insertByBo(options);
        }
    }

    /**
     * 新增题库
     *
     * @param bo 题库
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(QuestionsBo bo) {
        Questions add = MapstructUtils.convert(bo, Questions.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            Long id =add.getId();
            addOptions(id, bo.getOptionsList(), bo.getQuestionsType(), bo.getCorrectOptionKey());
            bo.setId(id);
        }
        return flag;
    }

    /**
     * 修改题库
     *
     * @param bo 题库
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(QuestionsBo bo) {
        Questions update = MapstructUtils.convert(bo, Questions.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Questions entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除题库信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
