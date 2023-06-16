package cn.tedu.back.stage.management.superadmin.banner.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author = bianmy
 * DATE = 2023/6/12 19:13
 */
@Data
public class Banner {
    /**
    * 图片路径
    * */
    private String imgUrl;
    /**
     * 数据ID
     * */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 排序字段
     * */
    private int sort;
    /**
     * 开始时间
     * */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
    * 修改时间
    * */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}