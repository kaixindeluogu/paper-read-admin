package cn.tedu.back.stage.management.superadmin.banner.dao.mapper;

import cn.tedu.back.stage.management.superadmin.banner.pojo.entity.Banner;
import cn.tedu.back.stage.management.superadmin.banner.pojo.vo.BannerVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/16 17:10
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    List<BannerVO> listBannerAll();

}