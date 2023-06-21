package cn.tedu.back.stage.management.superadmin.report.dao.persist.repository.impl;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;

import cn.tedu.back.stage.management.superadmin.report.dao.persist.mapper.ReportMapper;
import cn.tedu.back.stage.management.superadmin.report.dao.persist.repository.IReportRepository;
import cn.tedu.back.stage.management.superadmin.report.pojo.entity.Report;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理举报信数据的存储库实现类
 *
 * Author = sun
 * DATE = 2023/6/16 20:43
 */
@Slf4j
@Repository
public class ReportRepositoryImpl implements IReportRepository {
    @Autowired
    private ReportMapper mapper;

    public ReportRepositoryImpl(){
        log.info("创建存储库对象:ReportRepositoryImpl");
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID删除举报数据】，参数：{}", id);
        return mapper.deleteById(id);
    }

    @Override
    public ReportStandardVO getStandardById(Long id) {
        log.debug("开始执行【根据ID查询举报信息】，参数：{}", id);
        return mapper.getStandardById(id);
    }

    @Override
    public PageData<ReportListItemVO> list(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询举报信息列表],页码:{},每页记录数据:{}",pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<ReportListItemVO> list = mapper.list();
        PageInfo<ReportListItemVO> pageInfo = new PageInfo<>(list);
        PageData<ReportListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }
}
