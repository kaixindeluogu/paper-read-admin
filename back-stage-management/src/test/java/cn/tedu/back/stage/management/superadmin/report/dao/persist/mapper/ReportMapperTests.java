package cn.tedu.back.stage.management.superadmin.report.dao.persist.mapper;

import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/6/18 22:07
 */
@SpringBootTest
public class ReportMapperTests {
    @Autowired
    ReportMapper mapper;

    @Test
    void getStandardById() {
        Long id = 1L;
        ReportStandardVO queryResult = mapper.getStandardById(id);
        System.out.println("根据ID查询数据完成，查询结果：" + queryResult);
    }

    @Test
    void listTagType() {
        List<?> list = mapper.list();
        System.out.println("查询列表完成，列表项的数量：" + list.size());
        for (Object item : list) {
            System.out.println("列表项：" + item);
        }
    }

}
