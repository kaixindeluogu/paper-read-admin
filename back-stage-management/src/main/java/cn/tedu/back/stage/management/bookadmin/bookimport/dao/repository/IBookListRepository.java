package cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository;

import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/17 23:38
 */
public interface IBookListRepository {

    /**
     * 统计查询
     * @return 统计查询
     */
    BookListTypeVO ListTypeSelect(Long id);


    int insert(Book book);

    int deleteById(Long id);

}