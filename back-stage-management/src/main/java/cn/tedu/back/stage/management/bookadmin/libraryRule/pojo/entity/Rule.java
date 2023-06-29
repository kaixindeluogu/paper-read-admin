package cn.tedu.back.stage.management.bookadmin.libraryRule.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = sun
 * DATE = 2023/6/25 23:29
 */
@Data
@TableName("zhipian_library_rule")
public class Rule implements Serializable {
    /**数据ID*/
    @TableId(type = IdType.AUTO)
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
    /**创建时间*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**修改时间*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
