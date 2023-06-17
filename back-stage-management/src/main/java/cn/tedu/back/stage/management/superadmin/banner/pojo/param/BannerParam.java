package cn.tedu.back.stage.management.superadmin.banner.pojo.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = bianmy
 * DATE = 2023/6/16 17:22
 */
@Data
public class BannerParam implements Serializable {
    private String imgUrl;
    private Integer sort;
    private String title;
}