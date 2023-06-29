package cn.tedu.back.stage.management.superadmin.report.service.impl;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.report.dao.persist.repository.IReportRepository;
import cn.tedu.back.stage.management.superadmin.report.pojo.entity.Report;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import cn.tedu.back.stage.management.superadmin.report.service.IReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *处理举报信息数据的业务实现类
 *
 * Author = sun
 * DATE = 2023/6/16 20:54
 */
@Slf4j
@Service
public class ReportServiceImpl implements IReportService {
    @Value("${zhipian_shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    private IReportRepository repository;

    public ReportServiceImpl(){
        log.info("创建业务对象:ReportServiceImpl");
    }


    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除举报信息】的业务，参数：{}", id);

        ReportStandardVO currentReport = repository.getStandardById(id);
        if (currentReport == null) {
            String message = "删除信息失败，尝试删除的标签数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = repository.deleteById(id);
        if (rows != 1) {
            String message = "删除标签失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
    }

    /*@Override
    public void updateInfoById(ReportUpdateInfoParam reportUpdateInfoParam) {

    }*/

    @Override
    public void setReportStatus(Long id) {
        log.debug("开始处理[通过审批]的业务,参数:{}",id);
        updateReportStatusById(id,1);
    }

    @Override
    public ReportStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据ID查询举报信息】业务，参数：{}", id);
        ReportStandardVO currentReport = repository.getStandardById(id);
        if (currentReport == null) {
            String message = "获取举报信息失败，尝试访问的举报信息不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return currentReport;
    }

    @Override
    public PageData<ReportListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询举报信息列表】业务，页码：{},每页记录数:{}", pageNum,pageSize);
        PageData<ReportListItemVO> pageData = repository.list(pageNum, pageSize);
        return pageData;
    }

    @Override
    public PageData<ReportListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询举报信息列表】业务，页码：{}", pageNum);
        PageData<ReportListItemVO> pageData = repository.list(pageNum, defaultQueryPageSize);
        return pageData;
    }

    private void updateReportStatusById(Long id, Integer status) {
        ReportStandardVO currentReport = repository.getStandardById(id);
        if (currentReport == null) {
            String message = "审批失败，尝试访问的的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        if (currentReport.getStatus() == status) {
            String message = "审批失败，该举报信息已经通过审批！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
        }

        Report report = new Report();
        report.setId(id);
        report.setStatus(status);
        int rows = repository.updateById(report);
        if (rows != 1) {
            String message = "服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UPDATE, message);
        }
    }
}
