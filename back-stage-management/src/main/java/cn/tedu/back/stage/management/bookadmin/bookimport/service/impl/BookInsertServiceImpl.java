package cn.tedu.back.stage.management.bookadmin.bookimport.service.impl;

import cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.IBookListRepository;
import cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.IPDFRepository;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.PDFData;
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
    @Autowired
    private IPDFRepository pdfRepository;


    @Override
    public BookListTypeVO ListTypeSelect(Long id) {
        return bookListRepository.ListTypeSelect(id);
    }

    @Override
    public void insert(BookTypeAddNewParam bookTypeAddNewParam) {
        log.debug("开始处理新增书籍业务, 参数:{} ", bookTypeAddNewParam);
        if (bookTypeAddNewParam.getCover()==null || bookTypeAddNewParam.getCover().equals("")){
            String message = "请选择图片";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }else if (bookTypeAddNewParam.getName() == null || bookTypeAddNewParam.getName().equals("")){
            String message = "请输入书名" ;
            throw  new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY ,message);
        }else if (bookTypeAddNewParam.getIntroduction() == null || bookTypeAddNewParam.getIntroduction().equals("")){
            String message = "详情介绍不能为空!" ;
            throw  new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY ,message);
        }else if ( bookTypeAddNewParam.getStoreAmount() == null || bookTypeAddNewParam.getStoreAmount() < 1 ){
            String message = "数量不能小于1!" ;
            throw  new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY ,message);
        }else if (bookTypeAddNewParam.getPdfUrl() == null){
            String message = "请上传PDF文件!" ;
            throw  new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY ,message);
        }

        Book book = new Book();
        PDFData pdfData = new PDFData();
        pdfData.setPdfUrl(bookTypeAddNewParam.getPdfUrl());
        BeanUtils.copyProperties(bookTypeAddNewParam, book);
        pdfRepository.insert(pdfData);
        bookListRepository.insert(book);
        pdfRepository.updateByCover(bookTypeAddNewParam);
    }

    /**
     * 暂时没有用到
     * @param id
     * @return
     */
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
