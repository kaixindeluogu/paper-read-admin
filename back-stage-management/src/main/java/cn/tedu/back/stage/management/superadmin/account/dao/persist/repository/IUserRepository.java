package cn.tedu.back.stage.management.superadmin.account.dao.persist.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:56
 */

public interface IUserRepository {
    /**
     * 插入User对象
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据name 查找内容
     * @param name
     * @return
     */
    int countByName(String name);

    /**
     * 根据ID删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 匹配的用户，如果没有匹配的数据，则返回null
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
     * 统计匹配名称查不匹配ID的用户数量，通常用于修改数据时判断名称是否被占用
     *
     * @param id   用户ID
     * @param name 用户数量
     * @return 匹配的用户的数量
     */
    int countByNameAndNotId(Long id, String name);
}
