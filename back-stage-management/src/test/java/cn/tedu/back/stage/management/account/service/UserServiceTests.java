package cn.tedu.back.stage.management.account.service;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.superadmin.account.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = lee
 * DATE   = 2023/6/21  0:08
 */
@SpringBootTest
public class UserServiceTests {
    @Autowired
    IUserService service;
    @Test
    void getStandardById() {
        Long id = 1L;

        try {
            Object queryResult = service.getStandardByID(id);
            System.out.println("根据ID查询数据完成，结果：" + queryResult);
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }
}
