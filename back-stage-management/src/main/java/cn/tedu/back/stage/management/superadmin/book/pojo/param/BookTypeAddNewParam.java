package cn.tedu.back.stage.management.superadmin.book.pojo.param;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookTypeAddNewParam {
    private Long id;             // 唯一标识
    private String name;        // 书名
    private String author;      // 作者
    private LocalDateTime publishTime;   // 出版日期
    private String publisher;   // 出版社
    private String status;      // 状态(在库，借出)
    private String storeAmount; // 库存数量
    private String introduction;// 详细介绍
}
