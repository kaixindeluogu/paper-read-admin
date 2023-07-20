package cn.tedu.back.stage.management.bookadmin.category.service.impl;

import cn.tedu.back.stage.management.bookadmin.category.dao.repository.ICategoryRepository;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListByParentItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryStandardVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.entity.Category;
import cn.tedu.back.stage.management.bookadmin.category.pojo.param.CategoryAddNewParam;
import cn.tedu.back.stage.management.bookadmin.category.pojo.param.CategoryUpdateInfoParam;
import cn.tedu.back.stage.management.bookadmin.category.service.ICategoryService;
import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Author = sun
 * DATE = 2023/7/14 19:57
 */
@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;
    @Value("${zhipian_shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;

    @Override
    public void addNew(CategoryAddNewParam categoryAddNewParam) {
        String name = categoryAddNewParam.getName();
        int count = repository.countByName(name);
        if (count > 0){
            String message = "新增一级类别失败,该名称已被占用!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewParam,category);
        category.setParentId(0L);
        category.setDepth(1);
        category.setIsParent(1);
        int rows = repository.insert(category);
        if (rows != 1) {
            String message = "新增一级类别失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    @Override
    public void addNewSecond(CategoryAddNewParam categoryAddNewParam) {
        String name = categoryAddNewParam.getName();
        int count = repository.countByName(name);
        if (count > 0){
            String message = "新增二级类别失败,该名称已被占用!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT,message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewParam,category);
        category.setParentId(categoryAddNewParam.getParentId());
        category.setDepth(2);
        category.setIsParent(0);
        int rows = repository.insert(category);
        if (rows != 1) {
            String message = "新增二级类别失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_INSERT, message);
        }
    }

    @Override
    public void delete(Long id) {
        CategoryStandardVO currentTag = repository.getStandardById(id);
        if (currentTag == null) {
            String message = "删除标签失败，尝试删除的标签数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = repository.deleteById(id);
        if (rows != 1) {
            String message = "删除标签失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }
    }

    @Override
    public void updateInfoById(CategoryUpdateInfoParam categoryUpdateInfoParam) {
        Long id = categoryUpdateInfoParam.getId();
        CategoryStandardVO currentTag = repository.getStandardById(id);
        if (currentTag == null || currentTag.getParentId() == 0) {
            String message = "修改二级类别失败，尝试修改的标签数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        String name = categoryUpdateInfoParam.getName();
        int count = repository.countByNameAndNotId(id, name);
        if (count > 0 || currentTag.getParentId() == 0) {
            String message = "修改二级类别失败，标签名称已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateInfoParam,category );
        category.setParentId(categoryUpdateInfoParam.getParentId());
        int rows = repository.update(category);
        if (rows != 1) {
            String message = "修改二级类别失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public void update(CategoryUpdateInfoParam categoryUpdateInfoParam) {
        Long id = categoryUpdateInfoParam.getId();
        CategoryStandardVO currentTag = repository.getStandardById(id);
        if (currentTag == null) {
            String message = "修改一级类别失败，尝试修改的标签数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        String name = categoryUpdateInfoParam.getName();
        int count = repository.countByNameAndNotId(id, name);
        if (count > 0) {
            String message = "修改一级类别失败，标签名称已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateInfoParam,category );
        category.setParentId(categoryUpdateInfoParam.getParentId());
        int rows = repository.update(category);
        if (rows != 1) {
            String message = "修改一级类别失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }

    @Override
    public CategoryStandardVO getStandardById(Long id) {
        CategoryStandardVO queryResult = repository.getStandardById(id);
        if (queryResult == null || queryResult.getParentId() == 0) {
            String message = "查询二级类别详情失败，类别数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return queryResult;
    }


    @Override
    public PageData<CategoryListByParentItemVO> listByParentId(Integer pageNum) {
        PageData<CategoryListByParentItemVO> pageData = repository.listByParentId(pageNum, defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<CategoryListByParentItemVO> listByParentId(Integer pageNum, Integer pageSize) {
        PageData<CategoryListByParentItemVO> pageData = repository.listByParentId(pageNum, pageSize);
        return pageData;
    }

    @Override
    public PageData<CategoryListItemVO> list(Integer pageNum) {
        PageData<CategoryListItemVO> pageData = repository.list(pageNum,defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<CategoryListItemVO> list(Integer pageNum, Integer pageSize) {
        PageData<CategoryListItemVO> pageData = repository.list(pageNum,pageSize);
        return pageData;
    }
}
