package cn.tedu.back.stage.management.superadmin.account.controller;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserAddNewParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;
import cn.tedu.back.stage.management.superadmin.account.service.IUserService;
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
 * DATE   = 2023/6/16  21:00
 */

@Validated
@Slf4j
@RestController
@RequestMapping("/content/users")
@Api(tags = "1.1. 内容管理-用户管理")
public class UserController {
    public UserController() {
        log.info("创建控制器对象: UserController");
    }

    @Autowired
    private IUserService userService;

    @ApiOperation("新增用户")
    @ApiOperationSupport(order = 100)
    @PostMapping("add-new")
    public JsonResult addNew(@Validated UserAddNewParam userAddNewParam) {
        log.debug("开始处理(新增数据)的请求,参数:{}", userAddNewParam);
        userService.addNum(userAddNewParam);
        return JsonResult.ok();
    }

    @ApiOperation("删除用户")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签ID", required = true, dataType = "Long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable @Range(min = 1,message = "滚!!") Long id) {
        log.debug("开始处理【删除用户】的请求，参数：{}", id);
        userService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("根据id查询用户")
    @ApiOperationSupport(order = 400)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签ID", required = true, dataType = "long")
    })
    @GetMapping("/{id:[0-9]+}")
    public JsonResult getStandardById(
            @PathVariable
            @Range(min = 1,message = "获取用户失败，请提交合法的ID值！")Long  id){
        log.debug("开始处理【根据ID查询用户】的请求，参数：{}", id);
        UserStandardVO user = userService.getStandardByID(id);
        return JsonResult.ok(user);
    }

    @ApiOperation("查询用户列表")
    @ApiOperationSupport(order = 422)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("")
    public JsonResult list(Integer page, String queryType) {
        log.debug("开始处理【显示用户列表】请求，页码：{}", page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<UserListItemVO> pageData;
        if ("all".equals(queryType)) {
            pageData = userService.list(pageNum, Integer.MAX_VALUE);
        } else {
            pageData = userService.list(pageNum);
        }
        return JsonResult.ok(pageData);
    }

    @ApiOperation("修改用户")
    @ApiOperationSupport(order = 300)
    @PostMapping("/{id:[0-9]+}/update/info")
    public JsonResult updateInfoById(@Validated UserUpdateInfoParam userUpdateInfoParam){
        log.debug("开始处理[修改用户]的请求,参数:{}", userUpdateInfoParam);
        userService.updateInfoById(userUpdateInfoParam);
        return JsonResult.ok();
    }

    @ApiOperation("启用用户权限")
    @ApiOperationSupport(order = 310)
    @PostMapping("/{id:[0-9]+}/enable")
    public JsonResult setEnable(@PathVariable @Range(min = 1,message = "禁用标签失败,请提交合法的ID值") Long id) {
        log.debug("开始处理【启用标签】的请求，参数：{}", id);
        userService.setUserEnable(id);
        return JsonResult.ok();
    }
    @ApiOperation("禁用用户权限")
    @ApiOperationSupport(order = 311)
    @PostMapping("/{id:[0-9]+}/disable")
    public JsonResult setDisable(@PathVariable @Range(min = 1,message = "禁用标签失败,请提交合法的ID值") Long id){
        log.debug("开始处理【禁用标签】的请求，参数：{}", id);
        userService.setUserDisable(id);
        return JsonResult.ok();
    }
    
}
