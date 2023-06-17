package cn.tedu.back.stage.management.superadmin.banner.dao.repository.impl;

import cn.tedu.back.stage.management.superadmin.banner.dao.mapper.BannerMapper;
import cn.tedu.back.stage.management.superadmin.banner.dao.repository.IBannerListRepository;
import cn.tedu.back.stage.management.superadmin.banner.pojo.vo.BannerVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/17 23:39
 */
@Repository
@Slf4j
public class BannerAllRepositoryImpl implements IBannerListRepository {
    @Autowired
    private BannerMapper bannerMapper;
    public BannerAllRepositoryImpl() {
        log.info("创建数据库对象BannerAllRepositoryImpl");
    }
    @Override
    public List<BannerVO> bannerListAll() {
        log.info("开始查询banner数据");
        return bannerMapper.listBannerAll();
    }
}