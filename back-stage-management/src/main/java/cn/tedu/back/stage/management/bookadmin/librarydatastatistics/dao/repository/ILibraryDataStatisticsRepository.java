package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.dao.repository;

import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo.LibraryDataStatisticsListItemVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;


public interface ILibraryDataStatisticsRepository {

    /**
     *  根据Id查询
     * @param id 查询数据ID
     * @return 根据Id查询
     */
    LibraryDataStatisticsListItemVO listTypeId1(Long id);

    /**
     * 查询信息列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 信息列表的分页数据
     */
    PageData<LibraryDataStatisticsListItemVO> listTypeId1(Integer pageNum, Integer pageSize);

    /**
     * 根据ID删除信息数据
     *
     * @param id 尝试删除的信息的ID
     * @return 受影响的行数
     */
    int libraryDataStatisticsById(Long id);

}
