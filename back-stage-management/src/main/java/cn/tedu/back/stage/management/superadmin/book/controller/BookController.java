package cn.tedu.back.stage.management.superadmin.book.controller;


import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.book.pojo.entity.Book;
import cn.tedu.back.stage.management.superadmin.book.service.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理标签相关请求的控制器类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin/book")
@Api(tags = "1.1. 内容管理")
public class BookController {

    @Autowired
    private IBookService bookService;

    public BookController() {
        log.info("创建控制器对象：TagController");
    }
    
    @GetMapping("/select")
    @ApiOperation("查询书籍")
    public JsonResult getBookById() {
        Book book = (Book) bookService.selectType();
        return JsonResult.ok(book);
    }



//    @GetMapping("/delete")
//    @ApiOperation("查询书籍")
//    public JsonResult getBookById(Long id) {
//        bookService.delete(id);
//        return JsonResult.ok();
//    }


}