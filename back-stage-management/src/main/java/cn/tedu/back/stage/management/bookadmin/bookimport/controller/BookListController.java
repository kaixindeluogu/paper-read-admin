package cn.tedu.back.stage.management.bookadmin.bookimport.controller;


import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;
import cn.tedu.back.stage.management.bookadmin.bookimport.service.IBookInsertService;
import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Author = wsk
 * DATE = 2023/6/16 19:35
 */
@Slf4j
@RestController
@RequestMapping("/v1/admin/books")
public class BookListController {

    @Autowired
    private IBookInsertService bookInsertService;

    public BookListController() {
        log.info("创建控制器对象: bookInsertService");
    }


    /**
     * 增加图书馆内书籍请求
     * @param bookTypeAddNewParam
     * @return
     */
    @PostMapping("uploadType")
    public JsonResult upload(@RequestBody BookTypeAddNewParam bookTypeAddNewParam) {
        log.debug("开始处理新增书籍导入业务请求:{}", bookTypeAddNewParam);
        bookInsertService.insert(bookTypeAddNewParam);
        return JsonResult.ok();
    }


    /**
     * 暂时没有用到
     * @param id
     * @return
     */
    @GetMapping("/{id}/deleteType")
    public JsonResult delete(@PathVariable Long id) {
        log.info("开始处理删除请求:{}",id);
        bookInsertService.deleteById(id);
        return JsonResult.ok();
    }

}