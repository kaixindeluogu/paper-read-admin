package cn.tedu.back.stage.management.superadmin.report.controller;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import cn.tedu.back.stage.management.superadmin.report.service.IReportService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 处理举报信息相关请求的控制器类
 *
 * Author = sun
 * DATE = 2023/6/16 20:36
 */
@Slf4j
@RestController
@RequestMapping("/v1/admin/report/")
@Api(tags = "1.1. 举报内容管理")
@Validated
public class ReportController {
    @Autowired
    private IReportService service;

    public ReportController(){
        log.info("创建控制器对象:ReportController");
    }

    @ApiOperation("删除举报信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "举报信息ID", required = true, dataType = "long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable @Range(min = 1, message = "删除信息失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除举报信息】的请求，参数：{}", id);
        service.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation("根据id查询举报信息")
    @ApiOperationSupport(order = 410)
    @GetMapping("/{id:[0-9]+}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "举报信息ID", required = true, dataType = "long")
    })
    public JsonResult getStandardById(@PathVariable @Range(min = 1,message = "获取详情失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【根据id查询举报信息】的请求，参数：{}", id);
        ReportStandardVO report = service.getStandardById(id);
        return JsonResult.ok(report);
    }

    @ApiOperation("查询举报信息列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("/list")
    public JsonResult listTagType(Integer page, String queryType){
        log.debug("开始处理[查询举报信息列表]请求,页码:{}",page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<ReportListItemVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = service.list(1, Integer.MAX_VALUE);
        } else {
            pageData = service.list(pageNum);
        }
        return JsonResult.ok(pageData);
    }
}
