package cn.tedu.back.stage.management.superadmin.banner.service.impl;

import cn.tedu.back.stage.management.superadmin.banner.dao.repository.IBannerListRepository;
import cn.tedu.back.stage.management.superadmin.banner.dao.repository.IBannerRepository;
import cn.tedu.back.stage.management.superadmin.banner.pojo.param.BannerParam;
import cn.tedu.back.stage.management.superadmin.banner.pojo.vo.BannerVO;
import cn.tedu.back.stage.management.superadmin.banner.service.IBannerListService;
import cn.tedu.back.stage.management.superadmin.banner.service.IBannerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/17 23:45
 */
@Repository
@Slf4j
public class BannerListServiceImpl implements IBannerListService {
    @Autowired
    private IBannerListRepository bannerRepository;

    public BannerListServiceImpl() {
        log.info("开始创建处理业务对象BannerListServiceImpl");
    }



    @Override
    public List<BannerVO> bannerListAll()  {
        log.info("开始处理bannerListAll查询业务");
        List<BannerVO> bannerVOS = bannerRepository.bannerListAll();
        for (BannerVO bannerVO: bannerVOS) {
            //url解码 否则:号报错
            bannerVO.setImgUrl(URLDecoder.decode(bannerVO.getImgUrl()));
        }
        return bannerVOS;
    }
}