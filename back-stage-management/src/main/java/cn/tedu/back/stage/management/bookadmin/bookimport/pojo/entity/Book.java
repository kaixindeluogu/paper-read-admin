package cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "zhipian_book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long libraryId;
    private Long categoryId;
    private Long userId;
    private String name;
    private String author;
    private LocalDateTime publishTime;
    private String publisher;
    private String status;
    private String cover;
    private Integer storeAmount;
    private Integer sort;
    private String introduction;
    private Integer borrowingVolume;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

}
