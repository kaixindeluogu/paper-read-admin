//package cn.tedu.back.stage.management.account.dao.persist.mapper;
//
//import cn.tedu.back.stage.management.superadmin.account.dao.persist.mapper.UserMapper;
//import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
//import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
///**
// * Author = lee
// * DATE   = 2023/6/21  1:19
// */
//@SpringBootTest
//public class UserMapperTests {
//    @Autowired
//    UserMapper mapper;
//    @Test
//    void list(){
//        List<UserListItemVO> list = mapper.list();
//        System.out.println("查询列表完成，列表项的数量：" + list.size());
//        for (Object item :
//                list) {
//            System.out.println("列表项 = " +item);
//        }
//    }
//    @Test
//
//    void updateById() {
//        User user = new User();
//        user.setId(6L);
//        // tag.setName("测试标签名称998");
//        user.setNickName("新茶叶标签");
//        user.setUserName("娃哈哈");
//
//        int rows = mapper.updateById(user);
//        System.out.println("修改数据成功，受影响的行数：" + rows);
//    }
//
//}
