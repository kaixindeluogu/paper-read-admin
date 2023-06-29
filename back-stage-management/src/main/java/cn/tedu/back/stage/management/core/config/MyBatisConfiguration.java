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
@MapperScan({
        "cn.tedu.back.stage.management.superadmin.account.dao.persist.mapper",
        "cn.tedu.back.stage.management.superadmin.banner.dao.mapper",
        "cn.tedu.back.stage.management.superadmin.libraryapply.dao.mapper",
        "cn.tedu.back.stage.management.superadmin.report.dao.persist.mapper",
        "cn.tedu.back.stage.management.superadmin.book.persist.mapper",
        "cn.tedu.back.stage.management.superadmin.dataStatistics.dao.mapper",
        "cn.tedu.back.stage.management.bookadmin.bookdetails.dao.mapper",
        "cn.tedu.back.stage.management.bookadmin.bookimport.dao.mapper",
        "cn.tedu.back.stage.management.bookadmin.**.**.mapper",

        "cn.tedu.back.stage.management.bookadmin.bookdetails.dao.mapper",
        "cn.tedu.back.stage.management.bookadmin.libraryRule.dao.mapper"
})
public class MyBatisConfiguration {

    public MyBatisConfiguration() {
        log.info("创建配置类对象：MyBatisConfiguration");
    }

}
