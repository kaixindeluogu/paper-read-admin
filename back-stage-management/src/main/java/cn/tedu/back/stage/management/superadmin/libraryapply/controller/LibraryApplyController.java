package cn.tedu.back.stage.management.superadmin.libraryapply.controller;

import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.LibraryApplyAddNewParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.service.ILibraryApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/admin/libraryApply/")
public class LibraryApplyController {
    @Autowired
    private ILibraryApplyService service;
    @PostMapping("/add-new")
    public JsonResult addNew(LibraryApplyAddNewParam libraryApplyAddNewParam){
        log.debug("开始处理新增图书馆业务请求:{}", libraryApplyAddNewParam);
        service.addNew(libraryApplyAddNewParam);
        return JsonResult.ok();

    }

}
