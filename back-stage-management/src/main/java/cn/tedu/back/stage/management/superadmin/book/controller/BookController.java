package cn.tedu.back.stage.management.superadmin.book.controller;


import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.superadmin.book.pojo.entity.Book;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import cn.tedu.back.stage.management.superadmin.book.service.IBookService;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JsonResult getBookById(Long id) {
        BookStandardVO book = bookService.selectBooksByIdNotZero(id);
        return JsonResult.ok(book);
    }



    @ApiOperation("删除书籍信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "书籍ID", required = true, dataType = "long")
    })
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable @Range(min = 1, message = "删除信息失败，请提交合法的ID值！") Long id) {
        log.debug("开始处理【删除书籍信息】的请求，参数：{}", id);
        bookService.delete(id);
        return JsonResult.ok();
    }


    @ApiOperation("查询书籍列表")
    @ApiOperationSupport(order = 420)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "queryType", value = "查询类型，当需要查询全部数据时，此参数值应该是all")
    })
    @GetMapping("/selectType")
    public JsonResult listTagType(Integer page, String queryType){
        log.debug("开始处理【查询书籍列表】请求,页码:{}",page);
        if (page == null) {
            page = 1;
        }
        Integer pageNum = page > 0 ? page : 1;
        PageData<BookStandardVO> pageData ;
        if ("all".equals(queryType)) {
            pageData = bookService.listType(1, Integer.MAX_VALUE);
        } else {
            pageData = bookService.listType(pageNum);
        }
        return JsonResult.ok(pageData);
    }


}