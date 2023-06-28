package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.dao.mapper;

import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.entity.LibraryDataStatistics;
import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo.LibraryDataStatisticsListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryDataStatisticsMapper extends BaseMapper<LibraryDataStatistics> {


    /**
     *  根据Id查询
     * @param id 查询数据ID
     * @return 根据Id查询
     */
    LibraryDataStatisticsListItemVO listTypeId1(Long id);
    /**
     * 查询信息列表
     *
     * @return 信息列表
     */
    List<LibraryDataStatisticsListItemVO> listType1();
}
