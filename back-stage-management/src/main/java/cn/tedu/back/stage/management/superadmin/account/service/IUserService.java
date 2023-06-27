package cn.tedu.back.stage.management.superadmin.account.service;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserAddNewParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:58
 */
public interface IUserService {

    /**
     * 启用状态的显示文本
     */
    String[] ENABLE_TEXT = {"禁用" , "启用"};

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

    /**
     * 通过 ID启用用户的权限
     * @param id
     */
    void setUserEnable(Long id);

    /**
     * 通过 ID禁用用户的权限
     * @param id
     */
    void setUserDisable(Long id);
}
