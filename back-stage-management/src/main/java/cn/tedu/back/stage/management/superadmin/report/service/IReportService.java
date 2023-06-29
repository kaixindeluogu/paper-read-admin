package cn.tedu.back.stage.management.superadmin.report.service;


import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IReportService {

    /**
     * 删除标签
     *
     * @param id 尝试删除的标签的ID
     */
    void delete(Long id);

    /**
     *修改举报信息
     *
     * @param reportUpdateInfoParam 封装了被修改数据的id和新数据的对象
     */
   /* void updateInfoById(ReportUpdateInfoParam reportUpdateInfoParam);*/

    /**
     * 通过审批
     *
     * @param id 举报信息的id
     */
    void setReportStatus(Long id);

    /**
     *根据ID查询举报信息
     *
     *  @param id 举报信息id
     *  @return 匹配的举报信息，如果没有匹配的数据，则返回null
     */
    ReportStandardVO getStandardById(Long id);

    /**
     * 查询举报信息列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 举报信息列表的分页数据
     */
    PageData<ReportListItemVO> list(Integer pageNum, Integer pageSize);

    /**
     * 查询举报信息列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return 举报信息列表的分页数据
     */
    PageData<ReportListItemVO> list(Integer pageNum);
}
