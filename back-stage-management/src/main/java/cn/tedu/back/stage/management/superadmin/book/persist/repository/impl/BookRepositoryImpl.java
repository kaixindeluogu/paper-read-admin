package cn.tedu.back.stage.management.superadmin.book.persist.repository.impl;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.util.PageInfoToPageDataConverter;
import cn.tedu.back.stage.management.superadmin.book.persist.mapper.BookMapper;
import cn.tedu.back.stage.management.superadmin.book.persist.repository.IBookRepository;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理标签数据的存储库实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Repository
public class BookRepositoryImpl implements IBookRepository {
    @Autowired
    private BookMapper bookMapper;

    public BookRepositoryImpl(){
        log.info("创建存储库对象:BookRepositoryImpl");
    }


    @Override
    public int deleteById(Long id) {
        log.debug("开始执行【根据ID删除举报数据】，参数：{}", id);
        return bookMapper.deleteById(id);
    }

    @Override
    public BookStandardVO selectBooksByIdNotZero(Long id) {
        BookStandardVO bookTypeAddNewParams = bookMapper.selectBooksByIdNotZero(id);
        return bookTypeAddNewParams;
    }

    @Override
    public PageData<BookStandardVO> listType(Integer pageNum, Integer pageSize) {
        log.debug("开始处理[查询举报信息列表],页码:{},每页记录数据:{}",pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<BookStandardVO> list = bookMapper.listType();
        PageInfo<BookStandardVO> pageInfo = new PageInfo<>(list);
        PageData<BookStandardVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }

}