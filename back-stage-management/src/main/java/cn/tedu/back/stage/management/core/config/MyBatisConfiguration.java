package cn.tedu.back.stage.management.core.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis的配置类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Configuration
@MapperScan({"cn.tedu.back.stage.management.superadmin.dao.mapper"})
public class MyBatisConfiguration {

    public MyBatisConfiguration() {
        log.info("创建配置类对象：MyBatisConfiguration");
    }

}
