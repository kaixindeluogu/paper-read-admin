package cn.tedu.back.stage.management.superadmin.report.pojo.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 新增举报信息的实体类
 *
 * Author = sun
 * DATE = 2023/6/16 20:23
 */
@Data
public class ReportAddNewParam implements Serializable {
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
}
