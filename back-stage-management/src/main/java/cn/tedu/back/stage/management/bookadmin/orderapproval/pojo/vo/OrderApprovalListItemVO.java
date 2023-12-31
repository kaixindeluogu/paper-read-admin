package cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author = lee
 * DATE   = 2023/6/28  18:09
 */
@Data
public class OrderApprovalListItemVO implements Serializable {
    private Long  id;

    private String userName;
    private String bookName;
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

}
