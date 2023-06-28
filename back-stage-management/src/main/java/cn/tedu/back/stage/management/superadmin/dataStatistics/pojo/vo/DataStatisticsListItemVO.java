package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DataStatisticsListItemVO {


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
    private Integer borrowingVolume;
    /**
     * 地址
     */
    private String address;
    /**
     * 评论量
     */
    private String userName;
}
