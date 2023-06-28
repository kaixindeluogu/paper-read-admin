package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.service.impl;

import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.dao.repository.ILibraryDataStatisticsRepository;
import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo.LibraryDataStatisticsListItemVO;
import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.service.ILibraryDataStatisticsService;
import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LibraryDataStatisticsServiceImpl implements ILibraryDataStatisticsService {
    @Value("${zhipian_shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;

    @Autowired
    private ILibraryDataStatisticsRepository libraryDataStatisticsRepository;

    @Override
    public LibraryDataStatisticsListItemVO listTypeId1(Long id) {
        log.debug("开始处理【根据ID查询信息】业务，参数：{}", id);
        LibraryDataStatisticsListItemVO currentReport = libraryDataStatisticsRepository.listTypeId1(id);
        if (currentReport == null) {
            String message = "获取信息失败，尝试访问的信息不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return currentReport;
    }

    @Override
    public PageData<LibraryDataStatisticsListItemVO> listTypeL1(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询信息列表】业务，页码：{},每页记录数:{}", pageNum,pageSize);
        PageData<LibraryDataStatisticsListItemVO> pageData = libraryDataStatisticsRepository.listTypeId1(pageNum, pageSize);
        return pageData;
    }

    @Override
    public PageData<LibraryDataStatisticsListItemVO> listTypeL(Integer pageNum) {
        log.debug("开始处理【查询信息列表】业务，页码：{}", pageNum);
        PageData<LibraryDataStatisticsListItemVO> pageData = libraryDataStatisticsRepository.listTypeId1(pageNum, defaultQueryPageSize);
        return pageData;
    }

    @Override
    public void LibraryDataStatisticsById(Long id) {
        log.debug("开始处理【删除信息】的业务，参数：{}", id);

        LibraryDataStatisticsListItemVO currentReport = libraryDataStatisticsRepository.listTypeId1(id);
        if (currentReport == null) {
            String message = "删除信息失败，尝试删除的标签数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = libraryDataStatisticsRepository.libraryDataStatisticsById(id);
        if (rows != 1) {
            String message = "删除标签失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
    }




}
