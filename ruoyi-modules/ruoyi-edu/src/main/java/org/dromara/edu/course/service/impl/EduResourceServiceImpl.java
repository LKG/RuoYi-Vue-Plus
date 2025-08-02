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
import org.dromara.edu.course.domain.bo.EduResourceBo;
import org.dromara.edu.course.domain.vo.EduResourceVo;
import org.dromara.edu.course.domain.EduResource;
import org.dromara.edu.course.mapper.EduResourceMapper;
import org.dromara.edu.course.service.IEduResourceService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资源Service业务层处理
 *
 * @author gg
 * @date 2025-07-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class EduResourceServiceImpl implements IEduResourceService {

    private final EduResourceMapper baseMapper;

    /**
     * 查询资源
     *
     * @param id 主键
     * @return 资源
     */
    @Override
    public EduResourceVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资源列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资源分页列表
     */
    @Override
    public TableDataInfo<EduResourceVo> queryPageList(EduResourceBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<EduResource> lqw = buildQueryWrapper(bo);
        Page<EduResourceVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资源列表
     *
     * @param bo 查询条件
     * @return 资源列表
     */
    @Override
    public List<EduResourceVo> queryList(EduResourceBo bo) {
        LambdaQueryWrapper<EduResource> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<EduResource> buildQueryWrapper(EduResourceBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<EduResource> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(EduResource::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), EduResource::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getCoverUrl()), EduResource::getCoverUrl, bo.getCoverUrl());
        lqw.eq(bo.getCategoryId() != null, EduResource::getCategoryId, bo.getCategoryId());
        lqw.eq(bo.getType() != null, EduResource::getType, bo.getType());
        lqw.eq(bo.getCheckStatus() != null, EduResource::getCheckStatus, bo.getCheckStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getTagIds()), EduResource::getTagIds, bo.getTagIds());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), EduResource::getDescription, bo.getDescription());
        lqw.eq(bo.getCollectCount() != null, EduResource::getCollectCount, bo.getCollectCount());
        lqw.eq(bo.getViewCount() != null, EduResource::getViewCount, bo.getViewCount());
        lqw.eq(bo.getIsPublished() != null, EduResource::getIsPublished, bo.getIsPublished());
        lqw.eq(bo.getPublishTime() != null, EduResource::getPublishTime, bo.getPublishTime());
        return lqw;
    }

    /**
     * 新增资源
     *
     * @param bo 资源
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(EduResourceBo bo) {
        EduResource add = MapstructUtils.convert(bo, EduResource.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资源
     *
     * @param bo 资源
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(EduResourceBo bo) {
        EduResource update = MapstructUtils.convert(bo, EduResource.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(EduResource entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资源信息
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
