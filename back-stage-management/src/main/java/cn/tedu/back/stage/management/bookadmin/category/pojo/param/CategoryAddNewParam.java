package cn.tedu.back.stage.management.bookadmin.category.pojo.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = sun
 * DATE = 2023/7/14 15:24
 */
@Data
public class CategoryAddNewParam implements Serializable {
    /**
     * 数据ID
     */
    private Long id;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 父级类别ID，如果无父级，则为0
     */
    private Long parentId;
    /**
     * 深度，最顶级类别的深度为1，次级为2，以此类推
     */
    private Integer depth;
    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 图标图片的URL
     */
    private String icon;
    /**
     * 是否为父级（是否包含子级），1=是父级，0=不是父级
     */
    private Integer isParent;
}