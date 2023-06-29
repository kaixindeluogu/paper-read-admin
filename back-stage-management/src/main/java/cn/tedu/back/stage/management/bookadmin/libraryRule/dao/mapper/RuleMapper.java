package cn.tedu.back.stage.management.bookadmin.libraryRule.dao.mapper;

import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.entity.Rule;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleListItemVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleMapper extends BaseMapper<Rule> {

    /**
     * 根据ID查询对应规则
     *
     * @param id 规则ID
     * @return 匹配的规则，如果没有匹配的数据，则返回null
     */
    RuleStandardVO getStandardById(Long id);

    /**
     * 查询规则列表
     *
     * @return 规则列表
     */
    List<RuleListItemVO> list();
}
