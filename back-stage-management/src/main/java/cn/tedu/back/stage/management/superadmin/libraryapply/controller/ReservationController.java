package cn.tedu.back.stage.management.superadmin.libraryapply.controller;


import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;

import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.ReservationUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo.ReservationListItemVO;
import cn.tedu.back.stage.management.superadmin.libraryapply.service.IReservationService;
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

@Slf4j
@RestController
@RequestMapping("/v1/admin/reservation")
@Api(tags = "1.1. 预约管理")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;


    public ReservationController() {
        log.info("创建控制器对象：ReservationController");
    }



    @ApiOperation("删除预约信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签ID", required = true, dataType = "long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable @Range(min = 1, message = "删除标签失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除标签】的请求，参数：{}", id);
        reservationService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("修改预约信息")
    @ApiOperationSupport(order = 300)
    @PostMapping("/{id:[0-9]+}/update/info")

    public JsonResult updateInfoById(@Validated ReservationUpdateInfoParam reservationUpdateInfoParam) {
        log.debug("开始处理【修改标签】的请求，参数：{}", reservationUpdateInfoParam);
        reservationService.updateInfoById(reservationUpdateInfoParam);
        return JsonResult.ok();
    }


    @ApiOperation("查询预约信息列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int")
    })
    @GetMapping("/list")
    public JsonResult ReservationList(Integer page,String queryTpe) {
        log.debug("开始处理【查询预约信息列表】请求，页码：{}", page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<ReservationListItemVO> pageData;
        if("all".equals(queryTpe)) {
            pageData=reservationService.listReservation(1,Integer.MAX_VALUE);
        }else {
            pageData=reservationService.listReservation(pageNum);
        }
        return JsonResult.ok(pageData);
    }
}
