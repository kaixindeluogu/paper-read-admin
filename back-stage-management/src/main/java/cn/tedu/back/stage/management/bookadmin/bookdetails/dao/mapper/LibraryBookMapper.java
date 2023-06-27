package cn.tedu.back.stage.management.bookadmin.bookdetails.dao.mapper;

import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.entiy.Book;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo.LibraryBookVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/22 0:10
 */
public interface LibraryBookMapper extends BaseMapper<Book> {
    List<LibraryBookVO> listLibraryBooks(Long id);
}