package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.service;

import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo.LibraryDataStatisticsListItemVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;

public interface ILibraryDataStatisticsService {
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
    PageData<LibraryDataStatisticsListItemVO> listTypeL1(Integer pageNum, Integer pageSize);

    /**
     * 查询 信息列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return  信息列表的分页数据
     */
    PageData<LibraryDataStatisticsListItemVO> listTypeL(Integer pageNum);


    /**
     * 删除
     *
     * @param id 尝试删除数据的ID
     */
    void LibraryDataStatisticsById(Long id);
}
