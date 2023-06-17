package cn.tedu.back.stage.management.superadmin.banner.dao.repository;

import cn.tedu.back.stage.management.superadmin.banner.pojo.vo.BannerVO;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/17 23:38
 */
public interface IBannerListRepository {
    List<BannerVO> bannerListAll();
}