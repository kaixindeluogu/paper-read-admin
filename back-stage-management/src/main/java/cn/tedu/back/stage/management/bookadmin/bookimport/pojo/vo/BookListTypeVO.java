package cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookListTypeVO {
    private Long id;                                            // 唯一表示
    private String name;                                        // '书名',
    private String author;                                      //  '作者',
    private String publisher;                                   //'出版社',
    private Long libraryId;                                     //'图书馆ID',
    private Long categoryId;                                    //'分类ID',
    private String status;                                      //'状态(在库,借出)',
    private String cover;                                       //'书籍封面',
    @JsonFormat(pattern = "yyy/MM/dd/ HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime publishTime;                          //'出版日期',
    private String storeAmount;                                 //'库存数量',
    private String introduction;                                //'详细介绍',
    @JsonFormat(pattern = "yyy/MM/dd/ HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime gmtCreate;                            //'数据创建时间',
}
