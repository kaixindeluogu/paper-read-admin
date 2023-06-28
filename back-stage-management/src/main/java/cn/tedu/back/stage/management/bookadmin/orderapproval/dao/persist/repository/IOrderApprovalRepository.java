package cn.tedu.back.stage.management.bookadmin.orderapproval.dao.persist.repository;

import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalListItemVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalStandardVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;


public interface IOrderApprovalRepository {

    /**
     * 根据ID删除举报信息数据
     *
     * @param id 尝试删除的举报信息的ID
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据ID查询订单信息
     *
     * @param id 订单信息ID
     * @return 匹配的订单信息，如果没有匹配的数据，则返回null
     */
    OrderApprovalStandardVO getStandardById(Long id);

    /**
     * 查询订单信息列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 订单信息列表的分页数据
     */
    PageData<OrderApprovalListItemVO> list(Integer pageNum, Integer pageSize);
}
