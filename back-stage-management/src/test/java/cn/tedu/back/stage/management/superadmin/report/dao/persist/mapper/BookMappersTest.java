package cn.tedu.back.stage.management.superadmin.report.dao.persist.mapper;

import cn.tedu.back.stage.management.superadmin.book.persist.mapper.BookMapper;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookMappersTest {
    @Autowired
    BookMapper mapper;

    @Test
    void a(){
        BookStandardVO bookTypeAddNewParams = mapper.selectBooksByIdNotZero(1L);
        System.out.println("查询结果:"+ bookTypeAddNewParams);
    }

    @Test
    void b(){
        System.out.println(mapper.listType());
    }

}
