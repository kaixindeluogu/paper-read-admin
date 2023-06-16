package cn.tedu.back.stage.management.superadmin.banner.controller;

import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.banner.pojo.param.BannerParam;
import cn.tedu.back.stage.management.superadmin.banner.service.IBannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author = bianmy
 * DATE = 2023/6/16 19:35
 */
@Slf4j
@RestController
@RequestMapping("/v1/admin/banner/")
public class BannerController {
    @Autowired
    private IBannerService bannerService;

    public BannerController() {
        log.info("创建控制器对象: bannerService");
    }

    @PostMapping("upload")
    public JsonResult upload(@RequestBody  BannerParam bannerParam) {
        log.debug("开始处理新增轮播表业务请求:{}",bannerParam);
        bannerService.insert(bannerParam);
        return JsonResult.ok();
    }


}