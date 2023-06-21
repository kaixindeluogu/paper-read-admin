package cn.tedu.back.stage.management.superadmin.account.pojo.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Author = lee
 * DATE   = 2023/6/16  17:52
 */
@Data
@TableName("zhipian_user")
public class User implements Serializable {

    @TableId(type =  IdType.AUTO)
    private long id;
    private Long userId;
    private String userName;
    private String password;
    private String nickName;
    private String admin;
    private String eMail;
    private String gender;
    private String phoneNumber;
    private Long idNumber;
    private BigDecimal account;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


}
