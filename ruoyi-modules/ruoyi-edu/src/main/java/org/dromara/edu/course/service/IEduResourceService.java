package org.dromara.edu.course.service;

import org.dromara.edu.course.domain.vo.EduResourceVo;
import org.dromara.edu.course.domain.bo.EduResourceBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资源Service接口
 *
 * @author gg
 * @date 2025-07-30
 */
public interface IEduResourceService {

    /**
     * 查询资源
     *
     * @param id 主键
     * @return 资源
     */
    EduResourceVo queryById(Long id);

    /**
     * 分页查询资源列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资源分页列表
     */
    TableDataInfo<EduResourceVo> queryPageList(EduResourceBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资源列表
     *
     * @param bo 查询条件
     * @return 资源列表
     */
    List<EduResourceVo> queryList(EduResourceBo bo);

    /**
     * 新增资源
     *
     * @param bo 资源
     * @return 是否新增成功
     */
    Boolean insertByBo(EduResourceBo bo);

    /**
     * 修改资源
     *
     * @param bo 资源
     * @return 是否修改成功
     */
    Boolean updateByBo(EduResourceBo bo);

    /**
     * 校验并批量删除资源信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
