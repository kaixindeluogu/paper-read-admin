package cn.tedu.back.stage.management.superadmin.book.service.impl;

import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.book.persist.repository.IBookRepository;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import cn.tedu.back.stage.management.superadmin.book.service.IBookService;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理标签数据的业务实现类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Service
public class BookServiceImpl implements IBookService {

    @Value("${zhipian_shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    IBookRepository bookRepository;

    public BookServiceImpl(){
        log.info("创建业务对象:BookServiceImpl");
    }



    @Override
    public BookStandardVO selectBooksByIdNotZero(Long id) {
        log.debug("开始处理【根据查询书籍信息】业务，无参数");
        return bookRepository.selectBooksByIdNotZero(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除书籍信息】业务 无参数");
        BookStandardVO bookTypeAddNewParams = bookRepository.selectBooksByIdNotZero(id);
        if (bookTypeAddNewParams == null) {
            String message = "删除信息失败，尝试删除的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = bookRepository.deleteById(id);
        if (rows != 1) {
            String message = "删除标签失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public PageData<BookStandardVO> listType(Integer pageNum, Integer pageSize) {
        log.debug("开始处理【查询书籍列表】业务，页码：{},每页记录数:{}", pageNum,pageSize);
        PageData<BookStandardVO> pageData = bookRepository.listType(pageNum, pageSize);
        return pageData;
    }

    @Override
    public PageData<BookStandardVO> listType(Integer pageNum) {
        log.debug("开始处理【查询书籍列表】业务，页码：{}", pageNum);
        PageData<BookStandardVO> pageData = bookRepository.listType(pageNum, defaultQueryPageSize);
        return pageData;
    }

}










