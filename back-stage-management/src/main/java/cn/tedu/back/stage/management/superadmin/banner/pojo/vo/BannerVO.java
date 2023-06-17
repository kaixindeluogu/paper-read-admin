package cn.tedu.back.stage.management.superadmin.banner.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author = bianmy
 * DATE = 2023/6/17 23:29
 */
@Data
public class BannerVO {
    private Long id;
    /**
     * 图片路径
     * */
    private String imgUrl;
    /**
     * 排序字段
     * */
    private int sort;
    /**
     * 标题名称
     * */
    private String title;
    /**
     * 开始时间
     * */
    private LocalDateTime gmtCreate;

}