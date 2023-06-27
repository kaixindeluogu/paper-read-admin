package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DataStatisticsListItemVO {


    private Long id;
    //zhipian_library需要的字段
    private String name;
    private Long clickNum;
    private String address;
    //zhipian_comment需要的字段
    private String userId;
    //zhipian_user需要的字段
    private String userName;
}
