package cn.tedu.back.stage.management.superadmin.dataStatistics.service.impl;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.dataStatistics.dao.repository.IDataStatisticsRepository;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsStandardVO;
import cn.tedu.back.stage.management.superadmin.dataStatistics.service.IDataStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DataStatisticsServiceImpl implements IDataStatisticsService {

    @Autowired
    private IDataStatisticsRepository dataStatisticsRepository;

    @Override
    public DataStatisticsListItemVO listTagType() {
        return dataStatisticsRepository.listTagType();
    }


//    @Override
//    public List<DataStatisticsListItemVO> listTagType(Long id) {
//
//        return dataStatisticsRepository.listTagType(id);
//    }


}
