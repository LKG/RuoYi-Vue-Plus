package org.dromara.edu.course.service.impl;

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
import org.dromara.edu.course.domain.bo.CoursePeriodBo;
import org.dromara.edu.course.domain.vo.CoursePeriodVo;
import org.dromara.edu.course.domain.CoursePeriod;
import org.dromara.edu.course.mapper.CoursePeriodMapper;
import org.dromara.edu.course.service.ICoursePeriodService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 课时Service业务层处理
 *
 * @author gg
 * @date 2025-07-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CoursePeriodServiceImpl implements ICoursePeriodService {

    private final CoursePeriodMapper baseMapper;

    /**
     * 查询课时
     *
     * @param id 主键
     * @return 课时
     */
    @Override
    public CoursePeriodVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询课时列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课时分页列表
     */
    @Override
    public TableDataInfo<CoursePeriodVo> queryPageList(CoursePeriodBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CoursePeriod> lqw = buildQueryWrapper(bo);
        Page<CoursePeriodVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的课时列表
     *
     * @param bo 查询条件
     * @return 课时列表
     */
    @Override
    public List<CoursePeriodVo> queryList(CoursePeriodBo bo) {
        LambdaQueryWrapper<CoursePeriod> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CoursePeriod> buildQueryWrapper(CoursePeriodBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CoursePeriod> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CoursePeriod::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), CoursePeriod::getTitle, bo.getTitle());
        lqw.eq(bo.getSortNum() != null, CoursePeriod::getSortNum, bo.getSortNum());
        lqw.eq(bo.getChapterId() != null, CoursePeriod::getChapterId, bo.getChapterId());
        lqw.eq(bo.getResourceId() != null, CoursePeriod::getResourceId, bo.getResourceId());
        lqw.eq(StringUtils.isNotBlank(bo.getContent()), CoursePeriod::getContent, bo.getContent());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), CoursePeriod::getDescription, bo.getDescription());
        lqw.eq(bo.getLearnHour() != null, CoursePeriod::getLearnHour, bo.getLearnHour());
        lqw.eq(bo.getCourseId() != null, CoursePeriod::getCourseId, bo.getCourseId());
        lqw.eq(StringUtils.isNotBlank(bo.getFileUrl()), CoursePeriod::getFileUrl, bo.getFileUrl());
        lqw.eq(bo.getType() != null, CoursePeriod::getType, bo.getType());
        return lqw;
    }

    /**
     * 新增课时
     *
     * @param bo 课时
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CoursePeriodBo bo) {
        CoursePeriod add = MapstructUtils.convert(bo, CoursePeriod.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改课时
     *
     * @param bo 课时
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CoursePeriodBo bo) {
        CoursePeriod update = MapstructUtils.convert(bo, CoursePeriod.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CoursePeriod entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除课时信息
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
