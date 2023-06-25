package cn.tedu.back.stage.management.superadmin.report.controller;

import cn.tedu.back.stage.management.superadmin.dataStatistics.service.IDataStatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
public class DataStatisticsControllerTests {
    @Autowired
    IDataStatisticsService service;

    @Test
    void i(){
        Long id = 1L;
        service.DataStatisticsById(id);
        System.out.println("删除成功");
    }


    @Test
    void I(){
        Long id = 1L;
        service.listTypeId(id);
        System.out.println("查询结果为:"+service.listTypeId(id));
    }
}
