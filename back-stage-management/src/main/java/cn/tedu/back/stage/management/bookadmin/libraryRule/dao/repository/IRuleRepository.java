package cn.tedu.back.stage.management.bookadmin.libraryRule.dao.repository;

import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.entity.Rule;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleListItemVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleStandardVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;

public interface IRuleRepository {
    /**
     * 插入规则数据
     *
     * @param rule 规则数据
     * @return 受影响的行数
     */
    int insert(Rule rule);

    /**
     * 根据ID修改规则数据
     *
     * @param rule 封装了被修改数据的ID和新数据的对象
     * @return 受影响的行数
     */
    int updateById(Rule rule);

    /**
     * 根据ID查询规则
     *
     * @param id 规则ID
     * @return 匹配的规则，如果没有匹配的数据，则返回null
     */
    RuleStandardVO getStandardById(Long id);

    /**
     * 查询规则列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 规则列表的分页数据
     */
    PageData<RuleListItemVO> list(Integer pageNum, Integer pageSize);
}
