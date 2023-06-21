package cn.tedu.back.stage.management.superadmin.dataStatistics.service;


import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;

import java.util.List;

public interface IDataStatisticsService {
    /**
     * 根据ID查询标签
     *
     * @param ? 标签ID
     * @return
     */
//       List<DataStatisticsListItemVO> listTagType(Long id);

    DataStatisticsListItemVO listTagType();
}
