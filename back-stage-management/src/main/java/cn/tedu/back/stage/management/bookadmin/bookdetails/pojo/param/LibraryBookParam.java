package cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.param;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = bianmy
 * DATE = 2023/6/22 0:14
 */
@Data
public class LibraryBookParam implements Serializable {

    /**
     * ID
     * */
    private Long id;
    /**
     * 书名
     * */
    private String name;
    /**
     * 作者
     * */
    private String author;

    /**
     * 出版社
     * */
    private String publisher;

    /**
     * 库存数量
     * */
    private String storeAmount;

    /**
     * 详细介绍
     */
    private String introduction;
}