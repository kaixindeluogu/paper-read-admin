package cn.tedu.back.stage.management.bookadmin.bookimport.service.impl;

import cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.IBookListRepository;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;
import cn.tedu.back.stage.management.bookadmin.bookimport.service.IBookInsertService;
import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class BookInsertServiceImpl implements IBookInsertService{

    @Autowired
    private IBookListRepository bookListRepository;


    @Override
    public BookListTypeVO ListTypeSelect(Long id) {
        return bookListRepository.ListTypeSelect(id);
    }

    @Override
    public int insert(BookTypeAddNewParam bookTypeAddNewParam) {
        log.debug("开始处理新增书籍业务, 参数:{} ", bookTypeAddNewParam);

        Book book = new Book();
        BeanUtils.copyProperties(bookTypeAddNewParam, book);
        return bookListRepository.insert(book);
    }

    @Override
    public int deleteById(Long id) {
        log.debug("开始处理【删除书籍信息】业务 无参数");
        BookListTypeVO bookListTypeVO = bookListRepository.ListTypeSelect(id);
        if (bookListTypeVO == null) {
            String message = "删除信息失败，尝试删除的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND, message);
        }

        int rows = bookListRepository.deleteById(id);
        if (rows != 1) {
            String message = "删除标签失败，服务器忙，请稍后再试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERROR_UNKNOWN, message);
        }
        return bookListRepository.deleteById(id);
    }
}
