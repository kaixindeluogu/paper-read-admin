package cn.tedu.back.stage.management.superadmin.dataStatistics.dao.mapper;

import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.entity.DataStatistics;
import cn.tedu.back.stage.management.superadmin.dataStatistics.pojo.vo.DataStatisticsListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataStatisticsMapper extends BaseMapper<DataStatistics> {


    /**
     *  根据Id查询
     * @param id 查询数据ID
     * @return 根据Id查询
     */
    DataStatisticsListItemVO listTypeId(Long id);


    /**
     * 查询信息列表
     *
     * @return 信息列表
     */
    List<DataStatisticsListItemVO> listType();

}
