package cn.tedu.back.stage.management.superadmin.report.dao.persist.mapper;

import cn.tedu.back.stage.management.superadmin.report.pojo.entity.Report;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理举报数据的Mapper接口
 *
 * Author = sun
 * DATE = 2023/6/16 20:43
 */
@Repository
public interface ReportMapper extends BaseMapper<Report> {
    /**
     * 根据ID查询标签
     *
     * @param id 举报信息ID
     * @return 匹配相应的举报信息，如果没有匹配的数据，则返回null
     */
    ReportStandardVO getStandardById(Long id);

    /**
     * 查询举报信息列表
     *
     * @return 举报信息列表
     */
    List<ReportListItemVO> list();
}
