package cn.tedu.back.stage.management.bookadmin.libraryRule.controller;

import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param.RuleAddNewParam;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param.RuleUpdateInfoParam;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleListItemVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo.RuleStandardVO;
import cn.tedu.back.stage.management.bookadmin.libraryRule.service.IRuleService;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Author = sun
 * DATE = 2023/6/26 0:10
 */
@Slf4j
@RestController
@RequestMapping("/library/admin/rules")
@Validated
public class RuleController {
    @Autowired
    private IRuleService service;
    public RuleController(){
        log.info("创建控制器类对象:RuleController");
    }

    @PostMapping("/add-new")
    public JsonResult addNew(@Validated RuleAddNewParam ruleAddNewParam){
        log.debug("开始处理[规则导入]的请求,参数:{}",ruleAddNewParam);
        service.addNew(ruleAddNewParam);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/update/info")
    public JsonResult updateInfoById(@Validated RuleUpdateInfoParam ruleUpdateInfoParam) {
        log.debug("开始处理【修改规则】的请求，参数：{}", ruleUpdateInfoParam);
        service.updateInfoById(ruleUpdateInfoParam);
        return JsonResult.ok();
    }

    @GetMapping("/{id:[0-9]+}")
    public JsonResult getStandardById(@PathVariable @Range(min = 1, message = "获取标签详情失败，请提交合法的ID值！") Long id){
        log.debug("开始处理[根据id查询规则]的请求,参数:{}",id);
        RuleStandardVO rule = service.getStandardById(id);
        return JsonResult.ok(rule);
    }

    @GetMapping("/list")
    public JsonResult listRule(Integer page, String queryType){
        log.debug("开始处理[查询规则列表]请求,页码:{}",page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<RuleListItemVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = service.list(1, Integer.MAX_VALUE);
        } else {
            pageData = service.list(pageNum);
        }
        return JsonResult.ok(pageData);
    }
}
