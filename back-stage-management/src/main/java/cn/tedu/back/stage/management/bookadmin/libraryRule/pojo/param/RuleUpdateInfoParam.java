package cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Author = sun
 * DATE = 2023/6/27 0:30
 */
@Data
public class RuleUpdateInfoParam implements Serializable {
    /**数据ID*/
    @NotNull(message = "请提交规则ID")
    @Range(min = 1, message = "请提交正确的规则ID值")
    @ApiModelProperty(value = "规则ID", required = true, example = "1")
    private Long id;
    /**借阅期限*/
    @NotNull(message = "请设置借阅期限")
    private String borrowPeriod;
    /**最大借书量*/
    @NotNull(message = "请设置最大借书量")
    @Range(min = 1, message = "请提交正确的数值")
    private int borrowLimit;
    /**借阅规则*/
    @NotNull(message = "请设置借阅规则")
    private String borrowRule;
    /**逾期罚款规则*/
    @NotNull(message = "请设置逾期罚款规则")
    private String overdueFineRule;
    /**丢失或损坏规则*/
    @NotNull(message = "请设置丢失或损坏规则")
    private String lostDamageRule;
    /**图书馆ID*/
    @NotNull(message = "请提交图书馆编号")
    @Range(min = 1, message = "请提交正确的图书馆编号")
    @ApiModelProperty(value = "图书馆编号", required = true, example = "1")
    private Long libraryId;
}
