package cn.tedu.back.stage.management.superadmin.dao.repository.impl;

import cn.tedu.back.stage.management.superadmin.dao.mapper.BannerMapper;
import cn.tedu.back.stage.management.superadmin.dao.repository.IBannerRepository;
import cn.tedu.back.stage.management.superadmin.pojo.param.BannerParam;
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

    @Override
    public int insert(BannerParam bannerParam) {
        log.debug("");
        return 0;
    }
}