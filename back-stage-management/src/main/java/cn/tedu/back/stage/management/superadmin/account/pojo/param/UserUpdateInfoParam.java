package cn.tedu.back.stage.management.superadmin.account.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Author = lee
 * DATE   = 2023/6/21  12:47
 */
@Data
public class UserUpdateInfoParam implements Serializable {
    private Long id;
    @NotNull(message = "新增用户失败，请提交用户名称！")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$",
            message = "用户名称必须是2~10长度的字符组成，且不允许使用标点符号")
    @ApiModelProperty(value = "用户名称", required = true)
    private String userName;
    private String nickName;

}
