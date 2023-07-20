package cn.tedu.back.stage.management.bookadmin.category.service;

import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListByParentItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryStandardVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.param.CategoryAddNewParam;
import cn.tedu.back.stage.management.bookadmin.category.pojo.param.CategoryUpdateInfoParam;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICategoryService {
    /**
     * 添加一级类别
     *
     * @param categoryAddNewParam 新的类别数据
     */
    void addNew(CategoryAddNewParam categoryAddNewParam);


    /**
     * 添加二级类别
     *
     * @param categoryAddNewParam 新的类别数据
     */
    void addNewSecond(CategoryAddNewParam categoryAddNewParam);

    /**
     * 根据ID删除类别
     *
     * @param id 尝试删除的类别数据的ID
     */
    void delete(Long id);

    /**
     * 修改二级类别数据
     *
     * @param categoryUpdateInfoParam 类别的新数据
     */
    void updateInfoById(CategoryUpdateInfoParam categoryUpdateInfoParam);

    /**
     * 修改一级类别数据
     *
     * @param categoryUpdateInfoParam 类别的新数据
     */
    void update(CategoryUpdateInfoParam categoryUpdateInfoParam);

    /**
     * 根据id查询类别数据详情
     *
     * @param id 类别id
     * @return 匹配的类别数据详情，如果没有匹配的数据，则返回null
     */
    CategoryStandardVO getStandardById(Long id);


    /**
     * 根据父级类别查询其子级类别列表，将使用默认的每页记录数
     *
     * @param pageNum  页码
     * @return 类别列表
     */
    PageData<CategoryListByParentItemVO> listByParentId(Integer pageNum);

    /**
     * 根据父级类别查询其子级类别列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @return 类别列表
     */
    PageData<CategoryListByParentItemVO> listByParentId(Integer pageNum, Integer pageSize);

    /**
     * 查询一级类别列表，将使用默认的“每页记录数”
     *
     * @param pageNum 页码
     * @return 标签类别列表的分页数据
     */
    PageData<CategoryListItemVO> list(Integer pageNum);

    /**
     * 查询一级类别列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 标签类别列表的分页数据
     */
    PageData<CategoryListItemVO> list(Integer pageNum, Integer pageSize);
}
