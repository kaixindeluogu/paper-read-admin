package cn.tedu.back.stage.management.bookadmin.bookdetails.dao.repository;

import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.entiy.Book;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo.LibraryBookVO;

import java.util.List;

public interface IListLibraryBookRepository {
    List<LibraryBookVO> listLibraryBook(Long id);

    int deleteBookById(Long id);

    void updateBookById(Book book);

    Book selectBookById(Long id);
}
