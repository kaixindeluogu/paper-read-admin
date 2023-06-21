package cn.tedu.back.stage.management.superadmin.banner.controller;

import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.banner.pojo.param.BannerParam;
import cn.tedu.back.stage.management.superadmin.banner.pojo.vo.BannerVO;
import cn.tedu.back.stage.management.superadmin.banner.service.IBannerListService;
import cn.tedu.back.stage.management.superadmin.banner.service.IBannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

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
    public JsonResult upload(@RequestBody BannerParam bannerParam) {
        log.debug("开始处理新增轮播表业务请求:{}", bannerParam);
        bannerService.insert(bannerParam);

        return JsonResult.ok();
    }

    @GetMapping("/{id}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.info("开始处理删除请求:{}",id);
        int i = bannerService.deleteById(id);
        if (i > 0) {
            return JsonResult.ok();
        }
        String message = "删除失败";
        return JsonResult.fail(ServiceCode.ERROR_NOT_FOUND,message);
    }

    @Autowired
    private IBannerListService bannerListService;

    @PostMapping("list")
    public JsonResult list() throws IOException {
        log.debug("开始处理查询banner请求");
        List<BannerVO> bannerVOS = bannerListService.bannerListAll();
        for (BannerVO bannerVO : bannerVOS) {
            /**
            在上述代码中，使用了 Java 8 中新增的 Base64 类来进行编码和解码。
             其中，Base64.getEncoder().encodeToString(imageBytes)
             方法用于将字节数组转换成 base64 编码的字符串。
             需要注意的是，该方法返回的字符串不包含前缀 data:image/png;base64,，
             需要在返回给前端时手动添加.
            *
            * */
            Path imagePath = Paths.get("e:/files/" + bannerVO.getImgUrl());
            byte[] imageBytes = Files.readAllBytes(imagePath);
            // 将图片转换成 base64 编码
            String base64Img = Base64.getEncoder().encodeToString(imageBytes);
            bannerVO.setImgUrl("data:image/png;base64," + base64Img);
            // 将编码后的字符串返回给前端
        }
        return JsonResult.ok(bannerVOS);


    }
}