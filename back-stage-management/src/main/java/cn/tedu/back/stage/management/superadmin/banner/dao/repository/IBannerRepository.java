package cn.tedu.back.stage.management.superadmin.banner.dao.repository;

import cn.tedu.back.stage.management.superadmin.banner.pojo.entity.Banner;

import java.io.Serializable;

public interface IBannerRepository {
    int insert(Banner banner);

    int deleteById(Long id);
}
