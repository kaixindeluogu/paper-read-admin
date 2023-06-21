package cn.tedu.back.stage.management.superadmin.account.service;

import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserAddNewParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:58
 */
public interface IUserService {
    void addNum(UserAddNewParam addNewParam);

    /**
     * 根据id删除标签
     * * @param id
     */
    void deleteById(Long id );

    /**
     * 根据ID查询标签
     *
     * @param id 标签ID
     * @return 匹配的标签，如果没有匹配的数据，则返回null
     */
    UserStandardVO getStandardByID(Long id);

    /**
     * 查询用户列表
     * @param pageNum
     * @return
     */
    PageData<UserListItemVO> list(Integer pageNum);

    PageData<UserListItemVO> list(Integer pageNum, Integer pageSize);

    /**
     *修改信息
     * @param userUpdateInfoParam
     */
    void updateInfoById(UserUpdateInfoParam userUpdateInfoParam);
}
