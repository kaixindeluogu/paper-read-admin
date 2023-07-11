package cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.impl;


import cn.tedu.back.stage.management.bookadmin.bookimport.dao.mapper.BookInsertMapper;
import cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository.IBookListRepository;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.PDFData;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/17 23:39
 */
@Repository
@Slf4j
public class BookListRepositoryImpl implements IBookListRepository {
    @Autowired
    private BookInsertMapper bookInsertMapper;
    public BookListRepositoryImpl() {
        log.info("创建数据库对象BookAllRepositoryImpl");
    }
    @Override
    public BookListTypeVO ListTypeSelect(Long id) {
        log.info("开始查询数据");
        return bookInsertMapper.ListTypeSelect(id);
    }


    @Override
    public int insert(Book book) {
        log.debug("插入书籍数据:{}", book);
        return bookInsertMapper.insert(book);
    }




    /**
     * 暂未用到
     * @param id
     * @return
     */
    @Override
    public int deleteById(Long id) {
        return bookInsertMapper.deleteById(id);
    }
}