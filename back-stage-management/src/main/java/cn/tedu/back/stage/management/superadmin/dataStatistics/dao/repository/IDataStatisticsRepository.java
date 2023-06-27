package cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;

import java.util.List;
import java.util.Optional;

public interface IDataStatisticsRepository {



    /**
     * 根据ID删除信息数据
     *
     * @param id 尝试删除的信息的ID
     * @return 受影响的行数
     */
    int DataStatisticsById(Long id);

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
    PageData<DataStatisticsListItemVO> listTypeId(Integer pageNum, Integer pageSize);
}
