package cn.tedu.back.stage.management.superadmin.report.dao.persist.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.book.persist.repository.IBookRepository;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = sun
 * DATE = 2023/6/18 22:24
 */
@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    IBookRepository bookRepository;


    @Test
    void listTagType() {
        Integer pageNum = 2;
        Integer pageSize = 2;
        PageData<BookStandardVO> pageData = bookRepository.listType(pageNum, pageSize);
        System.out.println(pageData);
    }
}
