package cn.tedu.back.stage.management.superadmin.book.persist.repository.impl;

import cn.tedu.back.stage.management.superadmin.book.persist.mapper.BookMapper;
import cn.tedu.back.stage.management.superadmin.book.persist.repository.IBookRepository;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
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


    @Override
    public List<BookTypeAddNewParam> select() {
        List<BookTypeAddNewParam> bookTypeAddNewParams = bookMapper.selectBooksByIdNotZero();
        return bookTypeAddNewParams;
    }

//    @Override
//    public void delete(Long id) {
//        bookMapper.delete(id);
//    }
}