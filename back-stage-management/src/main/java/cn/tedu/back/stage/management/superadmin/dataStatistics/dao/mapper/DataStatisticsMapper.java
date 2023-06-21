package cn.tedu.back.stage.management.superadmin.dataStatistics.dao.mapper;

import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataStatisticsMapper extends BaseMapper<DataStatistics> {
//    List<DataStatisticsListItemVO> listTagType(Long id);

    DataStatisticsListItemVO listTagType();


}
