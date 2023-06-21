package cn.tedu.back.stage.management.superadmin.book.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BookListVO implements Serializable {
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
    private String storeAmount;
    private Integer sort;
    private String introduction;
    private Integer borrowingVolume;
}
