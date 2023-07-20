package cn.tedu.back.stage.management.bookadmin.category.dao.mapper;

import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListByParentItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryListItemVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.VO.CategoryStandardVO;
import cn.tedu.back.stage.management.bookadmin.category.pojo.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 批量插入类别数据
     *
     * @param categories 类别列表
     * @return 受影响的行数
     */
    int insertBatch(List<Category> categories);

    /**
     * 根据id查询类别数据详情
     *
     * @param id 类别ID
     * @return 匹配的类别数据详情，如果没有匹配的数据，则返回null
     */
    CategoryStandardVO getStandardById(Long id);

    /**
     * 查询一级类别数据列表
     *
     * @return 类别数据列表
     */
    List<CategoryListItemVO> list();

    /**
     * 根据父级类别查询二级类别列表
     *
     * @return 类别列表
     */
    List<CategoryListByParentItemVO> listByParentId();
}
