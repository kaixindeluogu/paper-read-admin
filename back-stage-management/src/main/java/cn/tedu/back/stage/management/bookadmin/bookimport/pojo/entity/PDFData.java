package cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * PDF实体表
 * Author = bianmy
 * DATE = 2023/7/10 22:40
 */

@Data
@TableName(value = "zhipian_data")
public class PDFData {
    @TableId(type = IdType.AUTO)
    /**
     * 主键ID
     */
    private Long id;

    /**
     * PDF的URL路径
     */
    private String pdfUrl;

    /**
     * 关联书籍主键ID
     */
    private Long bookId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}