package org.dromara.edu.exam.qu.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.edu.exam.qu.domain.bo.QuestionsOptionsBo;
import org.dromara.edu.exam.qu.domain.vo.QuestionsOptionsVo;
import org.dromara.edu.exam.qu.domain.QuestionsOptions;
import org.dromara.edu.exam.qu.mapper.QuestionsOptionsMapper;
import org.dromara.edu.exam.qu.service.IQuestionsOptionsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 题库选项Service业务层处理
 *
 * @author gg
 * @date 2025-08-01
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionsOptionsServiceImpl implements IQuestionsOptionsService {

    private final QuestionsOptionsMapper baseMapper;

    /**
     * 查询题库选项
     *
     * @param id 主键
     * @return 题库选项
     */
    @Override
    public QuestionsOptionsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询题库选项列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 题库选项分页列表
     */
    @Override
    public TableDataInfo<QuestionsOptionsVo> queryPageList(QuestionsOptionsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<QuestionsOptions> lqw = buildQueryWrapper(bo);
        Page<QuestionsOptionsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的题库选项列表
     *
     * @param bo 查询条件
     * @return 题库选项列表
     */
    @Override
    public List<QuestionsOptionsVo> queryList(QuestionsOptionsBo bo) {
        LambdaQueryWrapper<QuestionsOptions> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<QuestionsOptions> buildQueryWrapper(QuestionsOptionsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<QuestionsOptions> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(QuestionsOptions::getId);
        lqw.eq(bo.getQuestionsId() != null, QuestionsOptions::getQuestionsId, bo.getQuestionsId());
        lqw.like(StringUtils.isNotBlank(bo.getOptionName()), QuestionsOptions::getOptionName, bo.getOptionName());
        lqw.eq(bo.getScore() != null, QuestionsOptions::getScore, bo.getScore());
        lqw.eq(StringUtils.isNotBlank(bo.getAnswer()), QuestionsOptions::getAnswer, bo.getAnswer());
        lqw.eq(bo.getSortNum() != null, QuestionsOptions::getSortNum, bo.getSortNum());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionKey()), QuestionsOptions::getOptionKey, bo.getOptionKey());
        return lqw;
    }

    /**
     * 新增题库选项
     *
     * @param bo 题库选项
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(QuestionsOptionsBo bo) {
        QuestionsOptions add = MapstructUtils.convert(bo, QuestionsOptions.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改题库选项
     *
     * @param bo 题库选项
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(QuestionsOptionsBo bo) {
        QuestionsOptions update = MapstructUtils.convert(bo, QuestionsOptions.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(QuestionsOptions entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除题库选项信息
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
