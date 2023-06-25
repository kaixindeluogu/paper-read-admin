package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "zhipian_datastatistics")
public class DataStatistics {
    /**
     * 数据id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    //zhipian_library需要的字段
    private String name;
    private Long click_num;
    private String address;

    //zhipian_comment需要的字段
    private String user_id;

    //zhipian_user需要的字段
    private String user_name;
}
