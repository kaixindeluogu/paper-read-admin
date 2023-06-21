package cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository;

import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;

import java.util.List;
import java.util.Optional;

public interface IDataStatisticsRepository {


    /**
     * 根据ID查询标签
     *
     * @param ? 标签ID
     * @return 匹配的标签，如果没有匹配的数据，则返回null
     */
//    List<DataStatisticsListItemVO> listTagType(Long id);

    DataStatisticsListItemVO listTagType();
}
