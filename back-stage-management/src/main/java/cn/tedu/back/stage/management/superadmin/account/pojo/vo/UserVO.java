package cn.tedu.back.stage.management.superadmin.account.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Author = lee
 * DATE   = 2023/6/16  20:58
 */
@Data
public class UserVO implements Serializable {
    private Long id;
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
}
