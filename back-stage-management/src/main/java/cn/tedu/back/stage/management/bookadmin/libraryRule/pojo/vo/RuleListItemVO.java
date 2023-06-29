package cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = sun
 * DATE = 2023/6/27 0:10
 */
@Data
public class RuleListItemVO implements Serializable {
    /**数据ID*/
    private Long id;
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
    /**图书馆ID*/
    private Long libraryId;
}
