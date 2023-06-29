package cn.tedu.back.stage.management.bookadmin.libraryRule.dao.repository.impl;

import cn.tedu.back.stage.management.bookadmin.libraryRule.dao.mapper.RuleMapper;
import cn.tedu.back.stage.management.bookadmin.libraryRule.dao.repository.IRuleRepository;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.entity.Rule;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleListItemVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleStandardVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/6/25 23:49
 */
@Slf4j
@Repository
public class RuleRepositoryImpl implements IRuleRepository {

    @Autowired
    private RuleMapper mapper;

    public RuleRepositoryImpl(){
        log.info("创建存储库对象:RuleRepositoryImpl");
    }

    @Override
    public int insert(Rule rule) {
        log.debug("开始执行[导入规则]的数据访问,参数:{}",rule);
        return mapper.insert(rule);
    }

    @Override
    public int updateById(Rule rule) {
        log.debug("开始执行【根据ID修改规则数据】，参数：{}", rule);
        return mapper.updateById(rule);
    }

    @Override
    public RuleStandardVO getStandardById(Long id) {
        log.debug("开始执行【根据ID查询规则】，参数：{}", id);
        return mapper.getStandardById(id);
    }

    @Override
    public PageData<RuleListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询规则列表],页码:{},每页记录数据:{}",pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<RuleListItemVO> list = mapper.list();
        PageInfo<RuleListItemVO> pageInfo = new PageInfo<>(list);
        PageData<RuleListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }
}
