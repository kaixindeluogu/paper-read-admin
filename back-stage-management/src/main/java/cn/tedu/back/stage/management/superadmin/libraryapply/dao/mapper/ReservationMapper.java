package cn.tedu.back.stage.management.superadmin.libraryapply.dao.mapper;

import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Reservation;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo.ReservationListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationMapper extends BaseMapper<Reservation> {
    List<ReservationListItemVO> listReservation();

    ReservationListItemVO getStandardById(Long id);
}
