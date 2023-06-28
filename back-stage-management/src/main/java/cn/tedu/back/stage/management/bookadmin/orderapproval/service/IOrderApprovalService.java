package cn.tedu.back.stage.management.bookadmin.orderapproval.service;

import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalListItemVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalStandardVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IOrderApprovalService {

    /**
     * 删除标签
     *
     * @param id 尝试删除的标签的ID
     */
    void delete(Long id);

    /**
     *根据ID查询举报信息
     *
     *  @param id 举报信息id
     *  @return 匹配的举报信息，如果没有匹配的数据，则返回null
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

    /**
     * 查询订单信息列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return 订单信息列表的分页数据
     */
    PageData<OrderApprovalListItemVO> list(Integer pageNum);
}
