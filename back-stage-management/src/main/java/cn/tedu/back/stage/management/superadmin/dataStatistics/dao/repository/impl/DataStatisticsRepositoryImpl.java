package cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository.impl;

import cn.tedu.back.stage.management.superadmin.dataStatistics.dao.mapper.DataStatisticsMapper;
import cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository.IDataStatisticsRepository;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
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
    public DataStatisticsListItemVO listTagType() {
        return dataStatisticsMapper.listTagType();
    }

//    @Override
//    public List<DataStatisticsListItemVO> listTagType(Long id) {
//        return dataStatisticsMapper.listTagType(id);
//    }




}
