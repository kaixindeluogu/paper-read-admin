package cn.tedu.back.stage.management.bookadmin.category.pojo.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = sun
 * DATE = 2023/7/14 15:26
 */
@Data
public class CategoryUpdateInfoParam implements Serializable {

    /***
     * 数据id
     */
    private Long id;
    /**
     * 类别名称
     */
    private String name;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;

    /**
     * 排序序号
     */
    private Integer sort;

    /**
     *父类id
     */
    private Long parentId;
    /**
     * 图标图片的URL
     */
    private String icon;

}
