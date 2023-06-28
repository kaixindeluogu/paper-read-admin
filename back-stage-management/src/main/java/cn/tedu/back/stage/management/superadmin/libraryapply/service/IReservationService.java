package cn.tedu.back.stage.management.superadmin.libraryapply.service;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.ReservationUpdateInfoParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.vo.ReservationListItemVO;

public interface IReservationService {
    /**
     * 查询标签类别列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return 标签类别列表的分页数据
     */
    PageData<ReservationListItemVO> listReservation(Integer pageNum);

    /**
     * 查询标签类别列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 标签类别列表的分页数据
     */
    PageData<ReservationListItemVO> listReservation(Integer pageNum, Integer pageSize);

    void deleteById(Long id);

    void updateInfoById(ReservationUpdateInfoParam reservationUpdateInfoParam);





}
