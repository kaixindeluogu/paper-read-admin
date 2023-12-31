package cn.tedu.back.stage.management.superadmin.account.service.Impl;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.account.dao.persist.repository.IUserRepository;
import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserAddNewParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.param.UserUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;
import cn.tedu.back.stage.management.superadmin.account.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:59
 */

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Value("${back.stage.management.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired(required = false)
    private IUserRepository userRepository;

    @Override
    public void addNum(UserAddNewParam addNewParam) {
        log.debug("开始处理[新增用户]的业务,参数{}", addNewParam);
        if (userRepository.countByName(addNewParam.getUserName()) > 0) {
            String message = "新增用户失败,用户名称已存在";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        User user = new User();
        BeanUtils.copyProperties(addNewParam, user);
        user.setUserName(addNewParam.getUserName());
        user.setPassword(addNewParam.getPassword());
        userRepository.insert(user);
    }

    @Override
    public void updateInfoById(UserUpdateInfoParam userUpdateInfoParam) {
        log.debug("开始处理【修改数据】的业务，参数：{}", userUpdateInfoParam);

        Long id = userUpdateInfoParam.getId();
        UserStandardVO currentTag = userRepository.getStandardById(id);
        if (currentTag == null) {
            String message = "修改信息失败，尝试修改的信息数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        String name = userUpdateInfoParam.getUserName();
        int count = userRepository.countByNameAndNotId(id, name);
        if (count > 0) {
            String message = "修改数据失败，数据名称已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateInfoParam, user);
        int rows = userRepository.updateById(user);
        if (rows != 1) {
            String message = "修改数据失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("开始处理【删除用户】的业务，参数：{}", id);

        UserStandardVO currentUser = userRepository.getStandardById(id);
        if (currentUser == null) {
            String message = "删除用户失败，尝试删除的用户数据不存在！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void setUserEnable(Long id) {
        log.debug("开始启用用户的权限,参数为{}", id);
        updateEnableById(id, "user");
    }

    @Override
    public void setUserDisable(Long id) {
        log.debug("开始启用用户的权限,参数为{}", id);
        updateEnableById(id, "bookadmin");
    }

    @Override
    public void setUserAdmin(Long id) {
        log.debug("开始启用用户的权限,参数为{}", id);
        updateEnableById(id, "admin");
    }

    private void updateEnableById(Long id, String admin) {
        UserStandardVO currentUser = userRepository.getStandardById(id);
        if (currentUser.getAdmin() == admin) {
            String message =  "数据失败，用户已经处于"+admin+"状态！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }
        User user = new User();
        user.setUserId(id);
        user.setAdmin(admin);
        user.setId(id);
        int rows = userRepository.updateById(user);
        if (rows != 1) {
            String message = admin + "数据修改失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE,message);
        }
    }


    @Override
    public UserStandardVO getStandardByID(Long id) {

        log.debug("开始处理【根据ID查询用户】的业务，参数：{}", id);

        UserStandardVO currentUSer = userRepository.getStandardById(id);
        System.out.println("55555555555555555555555555555555555555555555555555555555555555555");
        System.out.println(currentUSer.getAdmin());
        if (currentUSer == null) {
            String message = "获取用户详情失败，尝试删除的用户数据不存在！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return currentUSer;
    }

    @Override
    public PageData<UserListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询用户列表】业务，页码：{}", pageNum);
        PageData<UserListItemVO> pageData = userRepository.list(pageNum, defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<UserListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询用户列表】业务，页码：{}，每页记录数：{}", pageNum, pageSize);
        PageData<UserListItemVO> pageData = userRepository.list(pageNum, pageSize);
        return pageData;
    }
}

