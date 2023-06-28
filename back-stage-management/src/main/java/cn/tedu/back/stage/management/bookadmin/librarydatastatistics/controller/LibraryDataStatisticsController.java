package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.controller;

import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo.LibraryDataStatisticsListItemVO;
import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.service.ILibraryDataStatisticsService;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
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
@RequestMapping("/v1/bookadmin/libraryDataStatistics/")
public class LibraryDataStatisticsController {

    @Autowired
    private ILibraryDataStatisticsService libraryDataStatisticsService;

    public LibraryDataStatisticsController(){
        log.info("创建控制器对象：LibraryDataStatisticsController");
    }

    @ApiOperation("根据id查询信息")
    @ApiOperationSupport(order = 410)
    @GetMapping("/{id:[0-9]+}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息ID", required = true, dataType = "long")
    })
    public JsonResult getStandardById(@PathVariable @Range(min = 1,message = "获取详情失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【根据id查询信息】的请求，参数：{}", id);
        LibraryDataStatisticsListItemVO report = libraryDataStatisticsService.listTypeId1(id);
        return JsonResult.ok(report);
    }

    @ApiOperation("查询信息列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("/list/select/Type")
    public JsonResult listTagType1(Integer page, String queryType){
        log.debug("开始处理[查询信息列表]请求,页码:{}",page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<LibraryDataStatisticsListItemVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = libraryDataStatisticsService.listTypeL1(1, Integer.MAX_VALUE);
        } else {
            pageData = libraryDataStatisticsService.listTypeL(pageNum);
        }
        return JsonResult.ok(pageData);
    }

    @ApiOperation("删除信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息ID", required = true, dataType = "long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult DataStatisticsById(@PathVariable @Range(min = 1, message = "删除信息失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除信息】的请求，参数：{}", id);
        libraryDataStatisticsService.LibraryDataStatisticsById(id);
        return JsonResult.ok();
    }

}
