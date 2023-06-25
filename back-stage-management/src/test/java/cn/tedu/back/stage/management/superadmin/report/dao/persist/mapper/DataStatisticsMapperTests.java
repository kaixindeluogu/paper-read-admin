package cn.tedu.back.stage.management.superadmin.report.dao.persist.mapper;

import cn.tedu.back.stage.management.superadmin.dataStatistics.dao.mapper.DataStatisticsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"})
@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DataStatisticsMapperTests {

    @Autowired
    DataStatisticsMapper mapper;

//    @Test
//    void getStandardById() {
//        Object queryResult = mapper.listTagType();
//        System.out.println("根据ID查询数据完成，查询结果：" + queryResult);
//    }
    }


