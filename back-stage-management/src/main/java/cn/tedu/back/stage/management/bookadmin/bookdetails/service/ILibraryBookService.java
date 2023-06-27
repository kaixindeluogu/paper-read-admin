package cn.tedu.back.stage.management.bookadmin.bookdetails.service;

import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.entiy.Book;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.param.LibraryBookParam;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo.LibraryBookVO;

import java.io.IOException;
import java.util.List;

public interface ILibraryBookService {

    /**
     * 根据图书馆ID查询该图书馆所有图书集合
    * */
    List<LibraryBookVO> ListLibraryBook(Long id) throws IOException;

    /**
     * 根据主键ID删除数据
    * */
    void deleteBookById(Long id);

    /**
     * 修改数据接受
    * */
    void updateBookById(LibraryBookParam libraryBookParam);

    /**
     * 按主键查询  用于修改数据弹窗
    * */
    Book selectParamById(Long id);


}
