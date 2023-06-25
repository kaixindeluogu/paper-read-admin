package cn.tedu.back.stage.management.superadmin.report.controller;

import cn.tedu.back.stage.management.superadmin.book.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
public class BookController {
    @Autowired
    IBookService service;
    @Test
    void T(){
        Long id  =1L;
        service.delete(id);
        log.debug("删除成功 删除参数 : {}" , id);
    }

    @Test
    void I(){
        Long id  =2L;
        service.selectBooksByIdNotZero(id);
        System.out.println("结果为 :"+service.selectBooksByIdNotZero(id));
    }


}
