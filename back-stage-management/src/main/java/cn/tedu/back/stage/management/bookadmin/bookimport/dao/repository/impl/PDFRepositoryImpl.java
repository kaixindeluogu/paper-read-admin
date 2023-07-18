package cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.impl;

import cn.tedu.back.stage.management.bookadmin.bookimport.dao.mapper.PDFInsertMapper;
import cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.IPDFRepository;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.PDFData;

import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param.BookTypeAddNewParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author = bianmy
 * DATE = 2023/7/10 23:40
 */
@Repository
@Slf4j
public class PDFRepositoryImpl implements IPDFRepository {
    @Autowired
    private PDFInsertMapper pdfMapper;
    @Override
    public void insert(PDFData data) {
        log.debug("插入PDF数据:{}", data);
        pdfMapper.insert(data);
    }

    /**
     * 根据上传的url路径获取到图书ID,修改PDF的BookID
     */
    @Override
    public void updateByCover(BookTypeAddNewParam book) {
        log.debug("修改PDF表的BookID");
        pdfMapper.updateByCover(book);
    }


}