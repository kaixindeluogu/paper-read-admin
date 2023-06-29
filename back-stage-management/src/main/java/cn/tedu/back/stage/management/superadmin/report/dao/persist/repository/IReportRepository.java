package cn.tedu.back.stage.management.superadmin.report.dao.persist.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.report.pojo.entity.Report;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;

/**
 * 处理举报信数据的存储库接口
 *
 * Author = sun
 * DATE = 2023/6/16 20:43
 */
public interface IReportRepository {

    /**
     * 根据ID删除举报信息数据
     *
     * @param id 尝试删除的举报信息的ID
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据ID修改举报数据
     *
     * @param report 封装了被修改数据的ID和新数据的对象
     * @return 受影响的行数
     */
    int updateById(Report report);


    /**
     * 根据ID查询举报信息
     *
     * @param id 举报信息ID
     * @return 匹配的举报信息，如果没有匹配的数据，则返回null
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
}
