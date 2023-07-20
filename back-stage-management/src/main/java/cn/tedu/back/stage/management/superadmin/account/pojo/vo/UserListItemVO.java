package cn.tedu.back.stage.management.superadmin.account.pojo.vo;

import lombok.Data;

import java.io.Serializable;


/**
 * Author = lee
 * DATE   = 2023/6/21  0:59
 */
@Data
public class UserListItemVO implements Serializable {
    private Long id;
    private String userName;
    private String nickName;
    private String admin;

}
