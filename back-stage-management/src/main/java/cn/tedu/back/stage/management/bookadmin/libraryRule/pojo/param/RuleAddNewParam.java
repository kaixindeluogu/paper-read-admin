package cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Author = sun
 * DATE = 2023/6/25 23:44
 */
@Data
public class RuleAddNewParam implements Serializable {
    /**借阅期限*/
    private String borrowPeriod;
    /**最大借书量*/
    private int borrowLimit;
    /**借阅规则*/
    private String borrowRule;
    /**逾期罚款规则*/
    private String overdueFineRule;
    /**丢失或损坏规则*/
    private String lostDamageRule;
    /**图书馆编号*/
    private Long libraryId;
}
