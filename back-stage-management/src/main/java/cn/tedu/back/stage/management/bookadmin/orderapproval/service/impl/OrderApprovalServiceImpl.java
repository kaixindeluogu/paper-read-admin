package cn.tedu.back.stage.management.bookadmin.orderapproval.service.impl;

import cn.tedu.back.stage.management.bookadmin.orderapproval.dao.persist.repository.IOrderApprovalRepository;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalListItemVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalStandardVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.service.IOrderApprovalService;
import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author = lee
 * DATE   = 2023/6/28  18:03
 */
@Slf4j
@Service
public class OrderApprovalServiceImpl implements IOrderApprovalService {

    private Integer defaultQueryPageSize =10;
    @Autowired
    private IOrderApprovalRepository repository;

    public OrderApprovalServiceImpl(){
        log.info("创建业务对象:ReportServiceImpl");
    }


    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除订单信息】的业务，参数：{}", id);

        OrderApprovalStandardVO currentReport = repository.getStandardById(id);
        if (currentReport == null) {
            String message = "删除信息失败，尝试删除的订单数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = repository.deleteById(id);
        if (rows != 1) {
            String message = "删除订单失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
    }

    @Override
    public OrderApprovalStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据ID查询订单信息】业务，参数：{}", id);
        OrderApprovalStandardVO currentReport = repository.getStandardById(id);
        if (currentReport == null) {
            String message = "获取订单信息失败，尝试访问的订单信息不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }
        return currentReport;
    }

    @Override
    public PageData<OrderApprovalListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询订单信息列表】业务，页码：{},每页记录数:{}", pageNum,pageSize);
        PageData<OrderApprovalListItemVO> pageData = repository.list(pageNum, pageSize);
        return pageData;
    }

    @Override
    public PageData<OrderApprovalListItemVO> list(Integer pageNum) {
        log.debug("开始处理【查询订单信息列表】业务，页码：{}", pageNum);
        PageData<OrderApprovalListItemVO> pageData = repository.list(pageNum, defaultQueryPageSize);
        return pageData;
    }
}
