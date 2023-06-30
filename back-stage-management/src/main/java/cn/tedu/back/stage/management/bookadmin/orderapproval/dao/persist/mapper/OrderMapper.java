package cn.tedu.back.stage.management.bookadmin.orderapproval.dao.persist.mapper;

import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.entity.OrderApproval;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalListItemVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalStandardVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<OrderApproval> {
    /**
     * 根据ID查询标签
     *
     * @param id 订单信息ID
     * @return 匹配相应的订单信息，如果没有匹配的数据，则返回null
     */
    OrderApprovalStandardVO getStandardById(Long id);

    /**
     * 查询订单信息列表
     *
     * @return 订单信息列表
     */
    List<OrderApprovalListItemVO> list();

}
