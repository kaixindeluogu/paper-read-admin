package cn.tedu.back.stage.management.bookadmin.category.pojo.VO;

import lombok.Data;

/**
 * Author = sun
 * DATE = 2023/7/20 9:10
 */
@Data
public class CategoryListByParentItemVO {
    /**
     * 数据ID
     */
    private Long id;
    /**
     * 类别名称
     */
    private String name;
    /**
     * (如果是二级分类)一级类别名称
     */
    private String parentName;
    /**
     * 父级类别ID，如果无父级，则为0
     */
    private Long parentId;
    /**
     * 排序序号
     */
    private Integer sort;
}
