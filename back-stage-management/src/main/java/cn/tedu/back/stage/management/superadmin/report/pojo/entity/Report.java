package cn.tedu.back.stage.management.superadmin.report.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author = sun
 * DATE = 2023/6/18 21:27
 */
@Data
@TableName("zhipian_report")
public class Report {
    /**数据ID*/
    @TableId(type = IdType.AUTO)
    private Long id;
    /**举报内容*/
    private String reportContent;
    /**上传举报内容图片路径*/
    private String imgUrl;
    /**举报用户的ID*/
    private Long userId;
    /**举报的图书*/
    private Long bookId;
    /**举报的图书馆*/
    private Long libraryId;
    /**创建时间*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**修改时间*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
