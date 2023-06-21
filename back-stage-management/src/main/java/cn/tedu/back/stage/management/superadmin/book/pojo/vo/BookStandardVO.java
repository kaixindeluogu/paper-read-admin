package cn.tedu.back.stage.management.superadmin.book.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookStandardVO {
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String status;
    private String storeAmount;
    private String introduction;
    private LocalDateTime gmtCreate;


}
