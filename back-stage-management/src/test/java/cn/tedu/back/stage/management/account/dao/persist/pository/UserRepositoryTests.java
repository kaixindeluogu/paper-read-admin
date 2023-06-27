package cn.tedu.back.stage.management.account.dao.persist.pository;

import cn.tedu.back.stage.management.superadmin.account.dao.persist.repository.IUserRepository;
import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


/**
 * Author = lee
 * DATE   = 2023/6/19  20:51
 */
@SpringBootTest
@Sql(scripts = {"classpath:/sql/truncate_table.sql",
        "classpath:/sql/insert_data.sql"})
//@Sql(scripts = {"classpath:/sql/truncate_table.sql", "classpath:/sql/insert_data.sql"},
//        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserRepositoryTests {
    @Autowired
    IUserRepository userRepository;
    @Test
    void insert(){
        User user = new User();
        user.setUserId(4L);
        user.setUserName("朱八");
        user.setNickName("八");
        user.setPassword("737382");
        user.setAdmin("0");
        user.setEMail("67825433@gmil.com");
        user.setGender("男");
        user.setIdNumber(00015L);
        user.setPhoneNumber("19967584930");

        System.out.println("插入数据之前，参数：" + user);
        int rows = userRepository.insert(user);
        System.out.println("插入数据完成，受影响的行数：" + rows);
        System.out.println("插入数据之后，参数：" + user);
    }

    @Test
    void deleteById() {
        Long id = 5L;
        int rows = userRepository.deleteById(id);
        System.out.println("删除数据完成，受影响的行数：" + rows);

    }
    @Test
    void getStandardById() {
        Long id = 1L;
        Object queryResult = userRepository.getStandardById(id);
        System.out.println("根据ID查询数据完成，查询结果：" + queryResult);
    }

    @Test
    void updateById() {
        User user = new User();
        user.setId(6L);
        user.setUserName("新茶叶标签");
        user.setNickName("娃哈哈");

        int rows = userRepository.updateById(user);
        System.out.println("修改数据完成，受影响的行数：" + rows);
    }

}
