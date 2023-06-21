package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "zhipian_shop")// 你自己写张数据库的表  把你需要的字段加进去
public class DataStatistics {
    //zhipian_library需要的字段
    private String name;
    private Long click_num;
    private String address;

    //zhipian_comment需要的字段
    private String user_id;

    //zhipian_user需要的字段
    private String user_name;
}
