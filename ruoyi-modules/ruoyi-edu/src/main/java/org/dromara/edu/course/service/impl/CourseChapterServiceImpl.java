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
import org.dromara.edu.course.domain.bo.CourseChapterBo;
import org.dromara.edu.course.domain.vo.CourseChapterVo;
import org.dromara.edu.course.domain.CourseChapter;
import org.dromara.edu.course.mapper.CourseChapterMapper;
import org.dromara.edu.course.service.ICourseChapterService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 课程章节Service业务层处理
 *
 * @author gg
 * @date 2025-07-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CourseChapterServiceImpl implements ICourseChapterService {

    private final CourseChapterMapper baseMapper;

    /**
     * 查询课程章节
     *
     * @param id 主键
     * @return 课程章节
     */
    @Override
    public CourseChapterVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询课程章节列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 课程章节分页列表
     */
    @Override
    public TableDataInfo<CourseChapterVo> queryPageList(CourseChapterBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<CourseChapter> lqw = buildQueryWrapper(bo);
        Page<CourseChapterVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的课程章节列表
     *
     * @param bo 查询条件
     * @return 课程章节列表
     */
    @Override
    public List<CourseChapterVo> queryList(CourseChapterBo bo) {
        LambdaQueryWrapper<CourseChapter> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<CourseChapter> buildQueryWrapper(CourseChapterBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<CourseChapter> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(CourseChapter::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), CourseChapter::getTitle, bo.getTitle());
        lqw.eq(bo.getSortNum() != null, CourseChapter::getSortNum, bo.getSortNum());
        lqw.eq(bo.getCourseId() != null, CourseChapter::getCourseId, bo.getCourseId());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), CourseChapter::getDescription, bo.getDescription());
        return lqw;
    }

    /**
     * 新增课程章节
     *
     * @param bo 课程章节
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(CourseChapterBo bo) {
        CourseChapter add = MapstructUtils.convert(bo, CourseChapter.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改课程章节
     *
     * @param bo 课程章节
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(CourseChapterBo bo) {
        CourseChapter update = MapstructUtils.convert(bo, CourseChapter.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(CourseChapter entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除课程章节信息
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
