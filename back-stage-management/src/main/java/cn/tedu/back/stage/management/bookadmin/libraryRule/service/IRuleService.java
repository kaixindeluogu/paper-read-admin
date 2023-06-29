package cn.tedu.back.stage.management.bookadmin.libraryRule.service;

import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param.RuleAddNewParam;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param.RuleUpdateInfoParam;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleListItemVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleStandardVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IRuleService {
    /**
     * 规则导入
     *
     * @param ruleAddNewParam 规则数据
     */
    void addNew(RuleAddNewParam ruleAddNewParam);

    /**
     * 修改规则
     *
     * @param ruleUpdateInfoParam 封装了被修改数据的ID和新数据的对象
     */
    void updateInfoById(RuleUpdateInfoParam ruleUpdateInfoParam);

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

    /**
     * 查询规则列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return 规则列表的分页数据
     */
    PageData<RuleListItemVO> list(Integer pageNum);
}
