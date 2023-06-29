package cn.tedu.back.stage.management.bookadmin.libraryRule.service.impl;

import cn.tedu.back.stage.management.bookadmin.libraryRule.dao.repository.IRuleRepository;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.entity.Rule;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param.RuleAddNewParam;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param.RuleUpdateInfoParam;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleListItemVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleStandardVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.service.IRuleService;
import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author = sun
 * DATE = 2023/6/25 23:58
 */
@Slf4j
@Service
public class RuleServiceImpl implements IRuleService {

    @Value("${zhipian_shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    private IRuleRepository repository;

    @Override
    public void addNew(RuleAddNewParam ruleAddNewParam) {
        log.debug("开始处理[规则导入]业务,参数:{}",ruleAddNewParam);
        Rule rule = new Rule();
        Long id = rule.getId();
        RuleStandardVO currentRule = repository.getStandardById(id);
        if (currentRule != null){
            String message = "规则导入失败,已有规则,如需重新导入,请点击修改项";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }
        BeanUtils.copyProperties(ruleAddNewParam,rule);
        int rows = repository.insert(rule);
        if (rows != 1) {
            String message = "规则导入失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    @Override
    public void updateInfoById(RuleUpdateInfoParam ruleUpdateInfoParam) {
        log.debug("开始处理【修改规则】的业务，参数：{}", ruleUpdateInfoParam);
        Long id = ruleUpdateInfoParam.getId();
        RuleStandardVO currentRule = repository.getStandardById(id);
        if (currentRule == null){
            String message = "获取规则失败,尝试修改的规则数据不存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND,message);
        }
        Rule rule = new Rule();
        BeanUtils.copyProperties(ruleUpdateInfoParam,rule);
        int rows = repository.updateById(rule);
        if (rows != 1) {
            String message = "修改规则失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public RuleStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据ID查询规则】业务，参数：{}", id);
        RuleStandardVO currentRule = repository.getStandardById(id);
        if (currentRule == null){
            String message = "获取规则失败,尝试访问的规则数据不存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND,message);
        }
        return currentRule;
    }

    @Override
    public PageData<RuleListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询规则列表】业务，页码：{},每页记录数:{}", pageNum,pageSize);
        PageData<RuleListItemVO> pageData = repository.list(pageNum, pageSize);
        return pageData;
    }

    @Override
    public PageData<RuleListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询规则列表】业务，页码：{}", pageNum);
        PageData<RuleListItemVO> pageData = repository.list(pageNum, defaultQueryPageSize);
        return pageData;
    }
}
