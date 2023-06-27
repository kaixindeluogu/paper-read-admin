package cn.tedu.back.stage.management.superadmin.dataStatistics.controller;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.service.IDataStatisticsService;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/admin/dataStatistics/")
public class DataStatisticsController {

    @Autowired
    private IDataStatisticsService dataStatisticsService;

    public DataStatisticsController(){
        log.info("创建控制器对象：DataStatisticsController");
    }

    @ApiOperation("删除信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息ID", required = true, dataType = "long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult DataStatisticsById(@PathVariable @Range(min = 1, message = "删除信息失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除信息】的请求，参数：{}", id);
        dataStatisticsService.DataStatisticsById(id);
        return JsonResult.ok();
    }


    @ApiOperation("根据id查询信息")
    @ApiOperationSupport(order = 410)
    @GetMapping("/{id:[0-9]+}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息ID", required = true, dataType = "long")
    })
    public JsonResult getStandardById(@PathVariable @Range(min = 1,message = "获取详情失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【根据id查询信息】的请求，参数：{}", id);
        DataStatisticsListItemVO report = dataStatisticsService.listTypeId(id);
        return JsonResult.ok(report);
    }


    @ApiOperation("查询信息列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("/list/select/Type")
    public JsonResult listTagType(Integer page, String queryType){
        log.debug("开始处理[查询信息列表]请求,页码:{}",page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<DataStatisticsListItemVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = dataStatisticsService.listType1(1, Integer.MAX_VALUE);
        } else {
            pageData = dataStatisticsService.listType(pageNum);
        }
        return JsonResult.ok(pageData);
    }

}
