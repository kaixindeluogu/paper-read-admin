package cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationListItemVO {
    /**
     * id,唯一标识
     */
    private Long id;
    /**
     * 预约时间
     */
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


}




