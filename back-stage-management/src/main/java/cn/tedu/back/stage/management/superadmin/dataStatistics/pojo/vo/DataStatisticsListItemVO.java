package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo;

import lombok.Data;

@Data
public class DataStatisticsListItemVO {

    //zhipian_library需要的字段
    private String name;
    private Long click_num;
    private String address;

    //zhipian_comment需要的字段
    private String user_id;

    //zhipian_user需要的字段
    private String user_name;
}
