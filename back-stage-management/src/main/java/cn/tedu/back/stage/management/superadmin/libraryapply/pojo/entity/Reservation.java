package cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@TableName(value = "zhipian_reservation")
public class Reservation {



    /**
     * id,唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 预约时间
     */
    @JsonFormat(pattern = "yyy年MM月dd日 HH:mm:ss" , timezone = "GMT+8")
    private LocalDateTime reservationTime;
    /**
     * 状态(已预约,已取消,已借阅,逾期)
     */
    private String status;
    /**
     * 取消原因
     */
    private String cancelReason;
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
    /**
     * 开始时间
     * */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     * */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

}
