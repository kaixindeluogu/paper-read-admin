package cn.tedu.back.stage.management.superadmin.banner.service;

import cn.tedu.back.stage.management.superadmin.banner.pojo.entity.Banner;
import cn.tedu.back.stage.management.superadmin.banner.pojo.param.BannerParam;

/**
 * Author = bianmy
 * DATE = 2023/6/16 19:18
 */
public interface IBannerService {
    void insert(BannerParam bannerParam);

    int deleteById(Long id);
}