package cn.tedu.back.stage.management.superadmin.banner.service;

import cn.tedu.back.stage.management.superadmin.banner.pojo.vo.BannerVO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IBannerListService {
    List<BannerVO> bannerListAll();
}
