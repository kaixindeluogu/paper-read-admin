package cn.tedu.back.stage.management.superadmin.report.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 列表项VO类--举报信息
 *
 * Author = sun
 * DATE = 2023/6/16 20:31
 */
@Data
public class ReportListItemVO implements Serializable {
    /**数据ID*/
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
    /**举报时间*/
    private LocalDateTime gmtCreate;
}
