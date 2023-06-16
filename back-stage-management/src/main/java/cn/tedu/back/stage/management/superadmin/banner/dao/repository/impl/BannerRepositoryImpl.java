package cn.tedu.back.stage.management.superadmin.banner.dao.repository.impl;

import cn.tedu.back.stage.management.superadmin.banner.dao.mapper.BannerMapper;
import cn.tedu.back.stage.management.superadmin.banner.dao.repository.IBannerRepository;
import cn.tedu.back.stage.management.superadmin.banner.pojo.entity.Banner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author = bianmy
 * DATE = 2023/6/16 17:18
 */
@Repository
@Slf4j
public class BannerRepositoryImpl implements IBannerRepository {

    @Autowired
    private BannerMapper bannerMapper;


    public BannerRepositoryImpl() {
        log.info("创建数据库对象:BannerRepositoryImpl");
    }

    @Override
    public int insert(Banner banner) {
        log.debug("向轮播图表中插入数据:" + banner);
        return bannerMapper.insert(banner);
    }
}