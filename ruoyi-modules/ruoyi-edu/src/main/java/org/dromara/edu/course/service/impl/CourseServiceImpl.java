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
import org.dromara.edu.course.domain.bo.CourseBo;
import org.dromara.edu.course.domain.vo.CourseVo;
import org.dromara.edu.course.domain.Course;
import org.dromara.edu.course.mapper.CourseMapper;
import org.dromara.edu.course.service.ICourseService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 课程信息Service业务层处理
 *
 * @author GG
 * @date 2025-07-24
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseMapper baseMapper;

    /**
     * 查询课程信息
     *
     * @param id 主键
     * @return 课程信息
     */
    @Override
    public CourseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询课程信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课程信息分页列表
     */
    @Override
    public TableDataInfo<CourseVo> queryPageList(CourseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Course> lqw = buildQueryWrapper(bo);
        Page<CourseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的课程信息列表
     *
     * @param bo 查询条件
     * @return 课程信息列表
     */
    @Override
    public List<CourseVo> queryList(CourseBo bo) {
        LambdaQueryWrapper<Course> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Course> buildQueryWrapper(CourseBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Course> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(Course::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), Course::getTitle, bo.getTitle());
        lqw.eq(bo.getIsRecommend() != null, Course::getIsRecommend, bo.getIsRecommend());
        lqw.eq(bo.getIsTop() != null, Course::getIsTop, bo.getIsTop());
        lqw.eq(bo.getIsRequired() != null, Course::getIsRequired, bo.getIsRequired());
        lqw.eq(StringUtils.isNotBlank(bo.getCoverUrl()), Course::getCoverUrl, bo.getCoverUrl());
        lqw.eq(bo.getCategoryId() != null, Course::getCategoryId, bo.getCategoryId());
        lqw.eq(bo.getType() != null, Course::getType, bo.getType());
        lqw.eq(bo.getCheckStatus() != null, Course::getCheckStatus, bo.getCheckStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getTagIds()), Course::getTagIds, bo.getTagIds());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), Course::getDescription, bo.getDescription());
        lqw.eq(bo.getCollectCount() != null, Course::getCollectCount, bo.getCollectCount());
        lqw.eq(bo.getViewCount() != null, Course::getViewCount, bo.getViewCount());
        lqw.eq(bo.getSourceType() != null, Course::getSourceType, bo.getSourceType());
        lqw.eq(bo.getIsPublished() != null, Course::getIsPublished, bo.getIsPublished());
        lqw.eq(bo.getIsPremium() != null, Course::getIsPremium, bo.getIsPremium());
        lqw.eq(bo.getPublishTime() != null, Course::getPublishTime, bo.getPublishTime());
        lqw.eq(bo.getNoticeScope() != null, Course::getNoticeScope, bo.getNoticeScope());
        lqw.eq(StringUtils.isNotBlank(bo.getNoticeUsers()), Course::getNoticeUsers, bo.getNoticeUsers());
        return lqw;
    }

    /**
     * 新增课程信息
     *
     * @param bo 课程信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CourseBo bo) {
        Course add = MapstructUtils.convert(bo, Course.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改课程信息
     *
     * @param bo 课程信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CourseBo bo) {
        Course update = MapstructUtils.convert(bo, Course.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Course entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除课程信息信息
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
