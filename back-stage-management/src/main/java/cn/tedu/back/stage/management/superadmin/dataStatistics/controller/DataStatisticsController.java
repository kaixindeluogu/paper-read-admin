package cn.tedu.back.stage.management.superadmin.dataStatistics.controller;

import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.service.IDataStatisticsService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/admin/dataStatistics/")
public class DataStatisticsController {

    @Autowired
    private IDataStatisticsService dataStatisticsService;

    public DataStatisticsController(){
        log.info("创建控制器对象：DataStatisticsController");
    }

    @ApiOperation("根据ID查询标签")
    @ApiOperationSupport(order = 410)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签ID", required = true, dataType = "long")
    })
    @GetMapping("/{id}")
    public JsonResult getStandardById() {
        log.debug("开始处理【根据ID查询】的请求");
        DataStatisticsListItemVO dataStatisticsListItemVO = dataStatisticsService.listTagType();
        return JsonResult.ok(dataStatisticsListItemVO);
    }

}
