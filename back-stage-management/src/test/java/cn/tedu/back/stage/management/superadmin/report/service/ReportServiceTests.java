package cn.tedu.back.stage.management.superadmin.report.service;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = sun
 * DATE = 2023/6/18 22:28
 */
@SpringBootTest
public class ReportServiceTests {
    @Autowired
    IReportService service;

    @Test
    void listTagType1() {
        Integer pageNum = 1;

        try {
            PageData<ReportListItemVO> pageData = service.list(pageNum);
            System.out.println(pageData);
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void listTagType2(){
        Integer pageNum = 1;
        Integer pageSize = 2;
        try {
            PageData<ReportListItemVO> pageData = service.list(pageNum,pageSize);
            System.out.println(pageData);
        }catch (ServiceException e){
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }
}
