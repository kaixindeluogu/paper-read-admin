package cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookTypeAddNewParam {
    private Long id;                                            // 唯一表示
    private String name;                                        // '书名',
    private Long libraryId;                                     //  图书馆ID
    private Long userId;                                        //   用户ID
    private String author;                                      //  '作者',
    private String publisher;                                   //'出版社',
    private Long categoryId;                                    //'分类ID',
    private String status;                                      //'状态(在库,借出)',
    private String cover;                                       //'书籍封面',
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime publishTime;                          //'出版日期',
    private Integer storeAmount;                                 //'库存数量',
    private String introduction;                                //'详细介绍',
    /**
     * PDF路径
     */
    private String pdfUrl;

}
