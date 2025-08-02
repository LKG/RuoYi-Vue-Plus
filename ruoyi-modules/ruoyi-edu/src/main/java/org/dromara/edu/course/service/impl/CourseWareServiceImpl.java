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
import org.dromara.edu.course.domain.bo.CourseWareBo;
import org.dromara.edu.course.domain.vo.CourseWareVo;
import org.dromara.edu.course.domain.CourseWare;
import org.dromara.edu.course.mapper.CourseWareMapper;
import org.dromara.edu.course.service.ICourseWareService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 课件Service业务层处理
 *
 * @author gg
 * @date 2025-07-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CourseWareServiceImpl implements ICourseWareService {

    private final CourseWareMapper baseMapper;

    /**
     * 查询课件
     *
     * @param id 主键
     * @return 课件
     */
    @Override
    public CourseWareVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询课件列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课件分页列表
     */
    @Override
    public TableDataInfo<CourseWareVo> queryPageList(CourseWareBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CourseWare> lqw = buildQueryWrapper(bo);
        Page<CourseWareVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的课件列表
     *
     * @param bo 查询条件
     * @return 课件列表
     */
    @Override
    public List<CourseWareVo> queryList(CourseWareBo bo) {
        LambdaQueryWrapper<CourseWare> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CourseWare> buildQueryWrapper(CourseWareBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CourseWare> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CourseWare::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), CourseWare::getTitle, bo.getTitle());
        lqw.eq(bo.getSortNum() != null, CourseWare::getSortNum, bo.getSortNum());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), CourseWare::getDescription, bo.getDescription());
        lqw.eq(bo.getCourseId() != null, CourseWare::getCourseId, bo.getCourseId());
        lqw.eq(bo.getResourceId() != null, CourseWare::getResourceId, bo.getResourceId());
        lqw.eq(StringUtils.isNotBlank(bo.getFileUrl()), CourseWare::getFileUrl, bo.getFileUrl());
        lqw.eq(bo.getType() != null, CourseWare::getType, bo.getType());
        return lqw;
    }

    /**
     * 新增课件
     *
     * @param bo 课件
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CourseWareBo bo) {
        CourseWare add = MapstructUtils.convert(bo, CourseWare.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改课件
     *
     * @param bo 课件
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CourseWareBo bo) {
        CourseWare update = MapstructUtils.convert(bo, CourseWare.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CourseWare entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除课件信息
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
