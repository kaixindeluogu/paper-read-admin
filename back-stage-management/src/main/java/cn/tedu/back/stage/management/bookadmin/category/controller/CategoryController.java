package cn.tedu.back.stage.management.bookadmin.category.controller;

import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListByParentItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryStandardVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.param.CategoryAddNewParam;
import cn.tedu.back.stage.management.bookadmin.category.pojo.param.CategoryUpdateInfoParam;
import cn.tedu.back.stage.management.bookadmin.category.service.ICategoryService;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Author = sun
 * DATE = 2023/7/14 15:13
 */
@Slf4j
@RestController
@RequestMapping("/admin/categories")
@Validated
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @PostMapping("/add-new")
    @ApiOperation("添加类别")
    @ApiOperationSupport(order = 100)
    public JsonResult addNew(@Valid CategoryAddNewParam categoryAddNewParam) {
        log.debug("开始处理【添加类别】的请求，参数：{}", categoryAddNewParam);
        service.addNew(categoryAddNewParam);
        return JsonResult.ok();
    }

    @ApiOperation("新增二级类别")
    @ApiOperationSupport(order = 110)
    @PostMapping("/add-new/second")
    public JsonResult addNewSecond(@Validated CategoryAddNewParam categoryAddNewParam) {
        log.debug("开始处理【新增二级类别】的请求，参数：{}", categoryAddNewParam);
        service.addNewSecond(categoryAddNewParam);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/delete")
    @ApiOperation("根据ID删除类别")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult delete(@PathVariable @Range(min = 1, message = "请提交有效的类别ID值！") Long id) {
        log.debug("开始处理【根据ID删除类别】的请求，参数：{}", id);
        service.delete(id);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/update/second")
    @ApiOperation("修改二级类别详情")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult updateInfoById(@Valid CategoryUpdateInfoParam categoryUpdateInfoParam) {
        service.updateInfoById(categoryUpdateInfoParam);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/update")
    @ApiOperation("修改一级类别详情")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult update(@Valid CategoryUpdateInfoParam categoryUpdateInfoParam) {
        service.update(categoryUpdateInfoParam);
        return JsonResult.ok();
    }

    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据ID查询类别详情")
    @ApiOperationSupport(order = 410)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别ID", required = true, dataType = "long")
    })
    public JsonResult getStandardById(
            @PathVariable @Range(min = 1, message = "请提交有效的类别ID值！") Long id) {
        log.debug("开始处理【根据ID查询类别详情】的请求，参数：{}", id);
        CategoryStandardVO queryResult = service.getStandardById(id);
        return JsonResult.ok(queryResult);
    }

    @ApiOperation("查询一级类别列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("/list")
    public JsonResult list(Integer page, String queryType) {
        log.debug("开始处理【查询一级类别列表】请求，页码：{}", page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<CategoryListItemVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = service.list(1, Integer.MAX_VALUE);
        } else {
            pageData = service.list(pageNum);
        }
        return JsonResult.ok(pageData);
    }

    @ApiOperation("查询二级分类列表")
    @ApiOperationSupport(order = 421)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("")
    public JsonResult listByParentId(Integer page, String queryType) {
        log.debug("开始处理【查询二级分类列表】请求，页码：{}", page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<CategoryListByParentItemVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = service.listByParentId(1, Integer.MAX_VALUE);
        } else {
            pageData = service.listByParentId(pageNum);
        }
        return JsonResult.ok(pageData);
    }
}
