package cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Reservation;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo.ReservationListItemVO;

import java.util.List;

public interface IReservationRepository {
    List<ReservationListItemVO> listReservation();

    PageData<ReservationListItemVO> listReservationItem(Integer pageNum, Integer pageSize);

    int deleteById(Long id);

    int updateById(Reservation reservation);

    ReservationListItemVO getStandardById(Long id);




}
