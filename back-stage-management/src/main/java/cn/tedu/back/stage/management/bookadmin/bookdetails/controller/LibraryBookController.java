package cn.tedu.back.stage.management.bookadmin.bookdetails.controller;

import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.entiy.Book;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.param.LibraryBookParam;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo.LibraryBookVO;
import cn.tedu.back.stage.management.bookadmin.bookdetails.service.ILibraryBookService;
import cn.tedu.back.stage.management.common.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/23 21:21
 */
@RestController
@RequestMapping("v1/bookadmin/book/")
@Slf4j
public class LibraryBookController {

    @Autowired
    private ILibraryBookService libraryBookService;

    @PostMapping("/{id}/list")
    public JsonResult listLibraryBooks(@PathVariable Long id) throws IOException {
        log.debug("查询图书店铺id请求{}",id);
        List<LibraryBookVO> libraryBookVOS = libraryBookService.ListLibraryBook(id);
        return JsonResult.ok(libraryBookVOS);
    }

    @PostMapping("/{id}/delete")
    public JsonResult deleteBookById(@PathVariable Long id) {
        log.info("删除图书店铺id请求{}",id);
        libraryBookService.deleteBookById(id);
        return JsonResult.ok();
    }

    @PostMapping("/update")
    public JsonResult updateBookById(@RequestBody LibraryBookParam libraryBookParam) {
        log.info("修改图书店铺Param对象请求{}",libraryBookParam);
        libraryBookService.updateBookById(libraryBookParam);
        return JsonResult.ok();
    }

    @PostMapping("/{id}")
    public JsonResult selectById(@PathVariable Long id){
        log.info("修改页面查询单本图书信息id{}",id);
        Book book = libraryBookService.selectParamById(id);
        return JsonResult.ok(book);

    }

}