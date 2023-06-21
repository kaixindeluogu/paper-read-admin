package cn.tedu.back.stage.management.superadmin.account.dao.persist.repository;

import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:56
 */

public interface IUserRepository {
    int insert(User user);

    int countByName(String name);

    int deleteById(Long id);
    /**
     * 根据ID查询标签
     *
     * @param id 标签ID
     * @return 匹配的标签，如果没有匹配的数据，则返回null
     */
    UserStandardVO getStandardById(Long id);

    /**
     * 查询用户列表功能
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageData<UserListItemVO> list(Integer pageNum, Integer pageSize);

    /**
     *根据id修改用户
     * @param user
     * @return
     */
    int updateById(User user);
    /**
     * 统计匹配名称查不匹配ID的标签数量，通常用于修改数据时判断名称是否被占用
     *
     * @param id   标签ID
     * @param name 标签数量
     * @return 匹配的标签的数量
     */
    int countByNameAndNotId(Long id, String name);
}
