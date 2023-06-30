package cn.tedu.back.stage.management.superadmin.account.dao.persist.mapper;

import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/6/16  19:48
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    UserStandardVO getStandardById(Long id);
    /**
     * 显示用户功能
     * @return
     */
    List<UserListItemVO> list();

}
