package cn.tedu.back.stage.management.superadmin.banner.service.impl;

import cn.tedu.back.stage.management.common.web.JsonResult;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.banner.dao.repository.IBannerRepository;
import cn.tedu.back.stage.management.superadmin.banner.pojo.entity.Banner;
import cn.tedu.back.stage.management.superadmin.banner.pojo.param.BannerParam;
import cn.tedu.back.stage.management.superadmin.banner.service.IBannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author = bianmy
 * DATE = 2023/6/16 19:19
 */

@Slf4j
@Service
public class BannerServiceImpl implements IBannerService {
    @Autowired
    private IBannerRepository iBannerRepository;

    public BannerServiceImpl() {
        log.info("创建业务对象: iBannerRepository ");
    }
    @Override
    public void insert(BannerParam bannerParam) {
        log.debug("开始处理新增轮播表业务, 参数:{} ", bannerParam);

        Banner banner = new Banner();
        BeanUtils.copyProperties(bannerParam, banner);
        iBannerRepository.insert(banner);
    }

    @Override
    public int deleteById(Long id) {



        return iBannerRepository.deleteById(id);
    }


}