package cn.tedu.back.stage.management.superadmin.account.dao.persist.repository.Impl;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;
import cn.tedu.back.stage.management.superadmin.account.dao.persist.mapper.UserMapper;
import cn.tedu.back.stage.management.superadmin.account.dao.persist.repository.IUserRepository;
import cn.tedu.back.stage.management.superadmin.account.pojo.entity.User;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserListItemVO;
import cn.tedu.back.stage.management.superadmin.account.pojo.vo.UserStandardVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:56
 */
@Slf4j
@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        log.debug("开始向[User]插入数据:{}", user);
        return userMapper.insert(user);
    }

    @Override
    public int countByName(String userName) {
        log.debug("根据名称【{}】统计【标签表】中的数据的数量", userName);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        return userMapper.selectCount(queryWrapper);
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行[根据id删除标签数据],参数为{}", id);
        return userMapper.deleteById(id);
    }

    @Override
    public UserStandardVO getStandardById(Long id) {
        log.debug("开始执行[根据id查询标签],参数{}",id);
        return userMapper.getStandardById(id);
    }
    @Override
    public int updateById(User user) {
        log.debug("开始执行【根据ID修改标签数据】，参数：{}", user);
        return userMapper.updateById(user);
    }
    @Override//显示标签列表功能
    public PageData<UserListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【显示标签列表功能】,页码：{}，每页记录数：{}", pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<UserListItemVO> list = userMapper.list();
        PageInfo<UserListItemVO> pageInfo = new PageInfo<>(list);
        PageData<UserListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;

    }
    @Override
    public int countByNameAndNotId(Long id, String name) {

        log.debug("开始执行【统计匹配名称查不匹配ID的标签数量】，ID：{}，名称：{}", id, name);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", name).ne("id", id);
        return userMapper.selectCount(queryWrapper);
    }
}
