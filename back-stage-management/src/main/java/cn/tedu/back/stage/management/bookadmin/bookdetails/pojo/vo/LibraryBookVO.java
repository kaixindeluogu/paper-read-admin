package cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = bianmy
 * DATE = 2023/6/22 0:14
 */
@Data
public class LibraryBookVO implements Serializable {

    /**
     * ID
     * */
    private Long id;
    /**
     * 图书馆ID
     * */
    private Long libraryId;
    /**
     * 分类ID
     * */
    private Long categoryId;
    /**
     * 书名
     * */
    private String name;
    /**
     * 作者
     * */
    private String author;
    /**
     * 出版时间
     * */
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private LocalDateTime publishTime;
    /**
     * 出版社
     * */

    private String publisher;
    /**
     * 书籍封面
     * */
    private String cover;
    /**
     * 库存数量
     * */
    private String storeAmount;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 详细介绍
     */
    private String introduction;
    /**
     * 创建时间
     * */
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private LocalDateTime gmtCreate;
}