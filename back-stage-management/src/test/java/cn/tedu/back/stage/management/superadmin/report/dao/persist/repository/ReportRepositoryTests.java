package cn.tedu.back.stage.management.superadmin.report.dao.persist.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.report.pojo.entity.Report;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import com.baomidou.mybatisplus.extension.api.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = sun
 * DATE = 2023/6/18 22:24
 */
@SpringBootTest
public class ReportRepositoryTests {
    @Autowired
    IReportRepository repository;


    @Test
    void listTagType() {
        Integer pageNum = 2;
        Integer pageSize = 2;
        PageData<ReportListItemVO> pageData = repository.list(pageNum, pageSize);
        System.out.println(pageData);
    }
}
