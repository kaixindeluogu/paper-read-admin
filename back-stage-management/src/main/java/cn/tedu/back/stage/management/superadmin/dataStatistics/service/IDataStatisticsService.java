package cn.tedu.back.stage.management.superadmin.dataStatistics.service;


import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;

import java.util.List;

public interface IDataStatisticsService {
    /**
     * 删除
     *
     * @param id 尝试删除数据的ID
     */
    void DataStatisticsById(Long id);


    /**
     *  根据Id查询
     * @param id 查询数据ID
     * @return 根据Id查询
     */
    DataStatisticsListItemVO listTypeId(Long id);

    /**
     * 查询信息列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 信息列表的分页数据
     */
    PageData<DataStatisticsListItemVO> listType1(Integer pageNum, Integer pageSize);

    /**
     * 查询 信息列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return  信息列表的分页数据
     */
    PageData<DataStatisticsListItemVO> listType(Integer pageNum);
}
