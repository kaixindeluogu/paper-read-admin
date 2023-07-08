package cn.tedu.back.stage.management.superadmin.account.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Author = lee
 * DATE   = 2023/6/18  20:29
 */
@Data
public class UserAddNewParam implements Serializable {
    private Long id;
    private Long userId;
    @NotNull(message = "新增用户失败，请提交用户名称！")
    @Pattern(regexp = "^[a-zA-Z\\u4e00-\\u9fa5]{2,10}$",
            message = "标签类别必须是2~10长度的字符组成，且不允许使用标点符号")
    @ApiModelProperty(value = "用户名称", required = true)
    private String userName;
    private String password;
    private String nickName;
    /**
     * 权限管理
     */
    private String admin;
    private String eMail;
    private String gender;
    private String phoneNumber;
    private Long idNumber;
    private BigDecimal account;
}
