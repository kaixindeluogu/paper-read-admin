package cn.tedu.back.stage.management.superadmin.book.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyy/MM/dd/ HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime gmtCreate;


}
