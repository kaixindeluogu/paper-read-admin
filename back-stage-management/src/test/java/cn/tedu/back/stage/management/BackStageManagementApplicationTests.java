package cn.tedu.back.stage.management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class BackStageManagementApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    DataSource dataSource;

    @Test
    void getConnection() throws Throwable {
        dataSource.getConnection();
    }
}
