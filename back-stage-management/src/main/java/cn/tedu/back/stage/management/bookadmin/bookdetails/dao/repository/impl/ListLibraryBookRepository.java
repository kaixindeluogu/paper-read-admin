package cn.tedu.back.stage.management.bookadmin.bookdetails.dao.repository.impl;

import cn.tedu.back.stage.management.bookadmin.bookdetails.dao.mapper.LibraryBookMapper;
import cn.tedu.back.stage.management.bookadmin.bookdetails.dao.repository.IListLibraryBookRepository;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.entiy.Book;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo.LibraryBookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/23 21:02
 */
@Slf4j
@Repository
public class ListLibraryBookRepository implements IListLibraryBookRepository {
    @Autowired
    private LibraryBookMapper libraryBookMapper;

    @Override
    public List<LibraryBookVO> listLibraryBook(Long id) {
        log.debug("查询图书店铺id业务{}",id);
        return libraryBookMapper.listLibraryBooks(id);
    }

    @Override
    public int deleteBookById(Long id) {

        return  libraryBookMapper.deleteById(id);

    }

    @Override
    public void updateBookById(Book book) {
        libraryBookMapper.updateById(book);
    }

    @Override
    public Book selectBookById(Long id) {
        return libraryBookMapper.selectById(id);
    }
}