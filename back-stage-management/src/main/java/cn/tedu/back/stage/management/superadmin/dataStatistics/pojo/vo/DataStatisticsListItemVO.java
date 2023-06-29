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
     * zhipian_library 图书馆名
     */
    private String name;
    /**
     * zhipian_book 总借阅量
     */
    private Integer borrowingVolume;
    /**
     * zhipian_library 地址
     */
    private String address;
    /**
     * zhipian_book 总书籍数量
     */
    private Integer storeAmount;
    /**
     * zhipian_user 总用户人数
     */
    private Integer userId;
}
