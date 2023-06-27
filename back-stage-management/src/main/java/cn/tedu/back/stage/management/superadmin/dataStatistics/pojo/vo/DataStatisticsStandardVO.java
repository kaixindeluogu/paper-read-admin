package cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStatisticsStandardVO implements Serializable {

    private Long id;

    //zhipian_library需要的字段
    /**
     * 图书馆名字
     */
    private String name;
    /**
     * 点击量
     */
    private Long click_num;
    /**
     * 图书馆地址
     */
    private String address;

    //zhipian_comment需要的字段
    /**
     * 总人数
     */
    private String user_id;

    //zhipian_user需要的字段
    /**
     *
     */
    private String user_name;
}
