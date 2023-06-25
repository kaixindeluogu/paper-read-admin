package cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository.impl;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;
import cn.tedu.back.stage.management.superadmin.dataStatistics.dao.mapper.DataStatisticsMapper;
import cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository.IDataStatisticsRepository;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class DataStatisticsRepositoryImpl implements IDataStatisticsRepository {

    @Autowired
    private DataStatisticsMapper dataStatisticsMapper;


    @Override
    public int DataStatisticsById(Long id) {
        log.debug("开始执行【根据ID删除数据】，参数：{}", id);
        return dataStatisticsMapper.deleteById(id);
    }

    @Override
    public DataStatisticsListItemVO listTypeId(Long id) {
        log.debug("开始执行【根据ID查询举报信息】，参数：{}", id);
        return dataStatisticsMapper.listTypeId(id);
    }


    @Override
    public PageData<DataStatisticsListItemVO> listTypeId(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询举报信息列表],页码:{},每页记录数据:{}",pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<DataStatisticsListItemVO> list = dataStatisticsMapper.listType();
        PageInfo<DataStatisticsListItemVO> pageInfo = new PageInfo<>(list);
        PageData<DataStatisticsListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }
}
