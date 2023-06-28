package cn.tedu.back.stage.management.superadmin.libraryapply.service.impl;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.IReservationRepository;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Reservation;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.ReservationUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo.ReservationListItemVO;
import cn.tedu.back.stage.management.superadmin.libraryapply.service.IReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReservationServiceImpl implements IReservationService {
    @Value("${zhipian_shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    private IReservationRepository reservationRepository;

    public ReservationServiceImpl() {
        log.info("创建业务对象：ReservationServiceImpl");
    }

    @Override
    public PageData<ReservationListItemVO> listReservation(Integer pageNum) {
        log.debug("开始处理[查询标签类别]业务,页码:{}",pageNum);
        PageData<ReservationListItemVO> pageData=reservationRepository.listReservationItem(pageNum,defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<ReservationListItemVO> listReservation(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询标签类别]业务,页码:{},每页记录数{}",pageNum,pageSize);
        PageData<ReservationListItemVO> pageData=reservationRepository.listReservationItem(pageNum,pageSize);
        return pageData;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("开始处理【删除预约信息】的业务，参数：{}", id);
        int rows = reservationRepository.deleteById(id);
        if(rows!=1){
            String message = "删除信息失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_DELETE, message);
        }
    }

    @Override
    public void updateInfoById(ReservationUpdateInfoParam reservationUpdateInfoParam) {
        log.debug("开始处理【修改预约信息】的业务，参数：{}", reservationUpdateInfoParam);
        Long id = reservationUpdateInfoParam.getId();
        ReservationListItemVO currentReservation = reservationRepository.getStandardById(id);
        if(currentReservation==null){
            String message="修改预约信息失败,尝试修改的数据不存在!";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND,message);
        }

        Reservation reservation=new Reservation();
        BeanUtils.copyProperties(reservationUpdateInfoParam,reservation);
        reservationRepository.updateById(reservation);




    }
}

