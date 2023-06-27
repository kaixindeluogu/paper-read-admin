package cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.impl;


import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;

import cn.tedu.back.stage.management.superadmin.libraryapply.dao.mapper.ReservationMapper;
import cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.IReservationRepository;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Reservation;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo.ReservationListItemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class ReservationRepositoryImpl implements IReservationRepository {

    @Autowired
    private ReservationMapper reservationMapper;
    @Override
    public List<ReservationListItemVO> listReservation() {
        return reservationMapper.listReservation();
    }

    @Override
    public PageData<ReservationListItemVO> listReservationItem(Integer pageNum, Integer pageSize) {
        log.debug("开始执行【查询预约信息列表】，页码：{}，每页记录数：{}", pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<ReservationListItemVO> reservationListItem = reservationMapper.listReservation();
        PageInfo<ReservationListItemVO> pageInfo = new PageInfo<>(reservationListItem);
        PageData<ReservationListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID删除预约信息数据】，参数：{}",id);
        return reservationMapper.deleteById(id);
    }

    @Override
    public int updateById(Reservation reservation) {
        log.debug("开始执行【根据ID修改预约信息数据】，参数：{}", reservation);
        return reservationMapper.updateById(reservation);
    }

    @Override
    public ReservationListItemVO getStandardById(Long id) {
        log.debug("开始执行【根据ID查询预约信息】，参数：{}", id);
        return reservationMapper.getStandardById(id);
    }


}
