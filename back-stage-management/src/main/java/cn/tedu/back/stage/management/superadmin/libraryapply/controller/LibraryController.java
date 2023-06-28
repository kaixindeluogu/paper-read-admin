package cn.tedu.back.stage.management.superadmin.libraryapply.controller;

import cn.tedu.back.stage.management.common.web.JsonResult;


import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.LibraryAddNewParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.service.ILibraryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/admin/library/")
@Api(tags = "1.2. 图书馆管理")
public class LibraryController {
    @Autowired
    private ILibraryService service;

    @PostMapping("/add-new")
    public JsonResult addNew(LibraryAddNewParam libraryAddNewParam) {
        log.debug("开始处理新增图书馆业务请求:{}", libraryAddNewParam);
        service.addNew(libraryAddNewParam);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable @Range(min = 1, message = "删除标签失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除标签】的请求，参数：{}", id);
        service.delete(id);
        return JsonResult.ok();
    }

}
