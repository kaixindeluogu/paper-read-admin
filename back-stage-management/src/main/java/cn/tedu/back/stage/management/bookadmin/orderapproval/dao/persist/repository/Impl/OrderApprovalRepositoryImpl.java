package cn.tedu.back.stage.management.bookadmin.orderapproval.dao.persist.repository.Impl;

import cn.tedu.back.stage.management.bookadmin.orderapproval.dao.persist.mapper.OrderMapper;
import cn.tedu.back.stage.management.bookadmin.orderapproval.dao.persist.repository.IOrderApprovalRepository;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalListItemVO;
import cn.tedu.back.stage.management.bookadmin.orderapproval.pojo.vo.OrderApprovalStandardVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/6/27  17:59
 */
@Slf4j
@Repository
public class OrderApprovalRepositoryImpl implements IOrderApprovalRepository {
    @Autowired
    private OrderMapper mapper;

    public OrderApprovalRepositoryImpl(){
        log.info("创建存储库对象:ReportRepositoryImpl");
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID删除订单数据】，参数：{}", id);
        return mapper.deleteById(id);
    }

    @Override
    public OrderApprovalStandardVO getStandardById(Long id) {
        log.debug("开始执行【根据ID查询订单信息】，参数：{}", id);
        return mapper.getStandardById(id);
    }

    @Override
    public PageData<OrderApprovalListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询订单信息列表],页码:{},每页记录数据:{}",pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<OrderApprovalListItemVO> list = mapper.list();
        PageInfo<OrderApprovalListItemVO> pageInfo = new PageInfo<>(list);
        PageData<OrderApprovalListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }

}
