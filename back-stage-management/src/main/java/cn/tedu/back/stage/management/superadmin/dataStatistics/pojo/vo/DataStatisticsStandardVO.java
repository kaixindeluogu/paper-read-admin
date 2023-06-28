package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class DataStatisticsStandardVO implements Serializable {

    /**
     * 数据id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 图书馆名
     */
    private String name;
    /**
     * 借阅量
     */
    private Integer borrowing_volume;
    /**
     * 地址
     */
    private String address;
    /**
     * 评论量
     */
    private String user_name;
}
