package cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Author = lee
 * DATE   = 2023/6/28  18:10
 */
@Data
public class OrderApprovalStandardVO  implements Serializable {
    private Long  id;
    /**
     * 预约时间
     */
    private Date reservationTime;
    /**
     * 状态(已预约,已取消,已借阅,逾期)
     */
    private String status;
    /**
     * 取消原因
     */
    private String cancelReason;
    /**
     * 归还时间
     */
    private Date returnTime;
    /**
     * 预约人数
     */
    private Long number;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 书籍ID
     */
    private Long bookId;
    /**创建时间*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**修改时间*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
    private String bookName;


}
