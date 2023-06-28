package cn.tedu.back.stage.management.bookadmin.orderapproval.controller;

import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalListItemVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalStandardVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.service.IOrderApprovalService;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
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
 * Author = lee
 * DATE   = 2023/6/27  17:58
 */
@Slf4j
@RestController
@RequestMapping("/admin/order")
@Api(tags = "2.1. 订单预约内容管理")
@Validated
public class OrderApprovalController {

    @Autowired
    private IOrderApprovalService service;

    public OrderApprovalController() {
        log.info("创建控制器对象:ReportController");
    }

    @ApiOperation("删除订单信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单信息ID", required = true, dataType = "long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable @Range(min = 1, message = "删除信息失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除订单信息】的请求，参数：{}", id);
        service.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation("根据id查询订单信息")
    @ApiOperationSupport(order = 410)
    @GetMapping("/{id:[0-9]+}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单信息ID", required = true, dataType = "long")
    })
    public JsonResult getStandardById(@PathVariable @Range(min = 1, message = "获取详情失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【根据id查询订单信息】的请求，参数：{}", id);
        OrderApprovalStandardVO report = service.getStandardById(id);
        return JsonResult.ok(report);
    }

    @ApiOperation("查询订单信息列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("/list")
    public JsonResult listTagType(Integer page, String queryType) {
        log.debug("开始处理[查询订单信息列表]请求,页码:{}", page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<OrderApprovalListItemVO> pageData;
        if ("all".equals(queryType)) {
            pageData = service.list(1, Integer.MAX_VALUE);
        } else {
            pageData = service.list(pageNum);
        }
        return JsonResult.ok(pageData);
    }
}

