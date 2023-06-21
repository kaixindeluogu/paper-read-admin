package cn.tedu.back.stage.management.superadmin.book.service.impl;

import cn.tedu.back.stage.management.superadmin.book.persist.repository.IBookRepository;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IBookRepository bookRepository;


    @Override
    public List<BookTypeAddNewParam> selectType() {
        return bookRepository.select();
    }

}










