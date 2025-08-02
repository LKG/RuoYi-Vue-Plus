package org.dromara.edu.exam.qu.service;

import org.dromara.edu.exam.qu.domain.vo.QuestionsOptionsVo;
import org.dromara.edu.exam.qu.domain.bo.QuestionsOptionsBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 题库选项Service接口
 *
 * @author gg
 * @date 2025-08-01
 */
public interface IQuestionsOptionsService {

    /**
     * 查询题库选项
     *
     * @param id 主键
     * @return 题库选项
     */
    QuestionsOptionsVo queryById(Long id);

    /**
     * 分页查询题库选项列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 题库选项分页列表
     */
    TableDataInfo<QuestionsOptionsVo> queryPageList(QuestionsOptionsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的题库选项列表
     *
     * @param bo 查询条件
     * @return 题库选项列表
     */
    List<QuestionsOptionsVo> queryList(QuestionsOptionsBo bo);

    /**
     * 新增题库选项
     *
     * @param bo 题库选项
     * @return 是否新增成功
     */
    Boolean insertByBo(QuestionsOptionsBo bo);

    /**
     * 修改题库选项
     *
     * @param bo 题库选项
     * @return 是否修改成功
     */
    Boolean updateByBo(QuestionsOptionsBo bo);

    /**
     * 校验并批量删除题库选项信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
