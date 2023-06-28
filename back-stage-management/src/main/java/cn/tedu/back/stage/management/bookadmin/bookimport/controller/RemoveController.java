package cn.tedu.back.stage.management.bookadmin.bookimport.controller;

import cn.tedu.back.stage.management.bookadmin.bookimport.service.IRemoveListService;
import cn.tedu.back.stage.management.common.web.JsonResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1/admin/fileType")
@Slf4j
@Api("1.1")
public class RemoveController {

    @Autowired
    private IRemoveListService listService;
    @PostMapping("")
    public JsonResult upload(MultipartFile file) throws IOException {
        log.debug("开始处理RemoveAndUploadFileController请求:{}", file);
        String s = listService.upload(file);
        return JsonResult.ok(s);
    }

    @GetMapping("removeType")
    public JsonResult remove(String url) {
        log.debug("开始处理请求remove:{}", url);
        listService.remove(url);
        return JsonResult.ok();
    }
}