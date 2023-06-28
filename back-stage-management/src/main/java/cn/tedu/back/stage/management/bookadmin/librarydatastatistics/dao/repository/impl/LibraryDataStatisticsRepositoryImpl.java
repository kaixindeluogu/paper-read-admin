package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.dao.repository.impl;

import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.dao.mapper.LibraryDataStatisticsMapper;
import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.dao.repository.ILibraryDataStatisticsRepository;
import cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo.LibraryDataStatisticsListItemVO;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class LibraryDataStatisticsRepositoryImpl implements ILibraryDataStatisticsRepository {

    @Autowired
    private LibraryDataStatisticsMapper libraryDataStatisticsMapper;

    @Override
    public LibraryDataStatisticsListItemVO listTypeId1(Long id) {
        log.debug("开始执行【根据ID查询信息】，参数：{}", id);
        return libraryDataStatisticsMapper.listTypeId1(id);
    }

    @Override
    public PageData<LibraryDataStatisticsListItemVO> listTypeId1(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询信息列表],页码:{},每页记录数据:{}",pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<LibraryDataStatisticsListItemVO> list = libraryDataStatisticsMapper.listType1();
        PageInfo<LibraryDataStatisticsListItemVO> pageInfo = new PageInfo<>(list);
        PageData<LibraryDataStatisticsListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }

    @Override
    public int libraryDataStatisticsById(Long id) {
        log.debug("开始执行【根据ID删除数据】，参数：{}", id);
        return libraryDataStatisticsMapper.deleteById(id);
    }
}
