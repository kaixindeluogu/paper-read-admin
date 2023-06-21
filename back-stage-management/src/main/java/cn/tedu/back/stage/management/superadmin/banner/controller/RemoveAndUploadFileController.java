package cn.tedu.back.stage.management.superadmin.banner.controller;

import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.banner.service.IRemoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Author = bianmy
 * DATE = 2023/6/17 21:21
 */

@RestController
@RequestMapping("/v1/admin/file")
@Slf4j
public class RemoveAndUploadFileController {

    @Autowired
    private IRemoveService service;
    @PostMapping("")
    public JsonResult upload(MultipartFile file) throws IOException {
        log.debug("开始处理RemoveAndUploadFileController请求:{}", file);
        String s = service.upload(file);
        return JsonResult.ok(s);
    }

    @GetMapping("remove")
    public JsonResult remove(String url) {
        log.debug("开始处理请求remove:{}", url);
        service.remove(url);
        return JsonResult.ok();
    }
}