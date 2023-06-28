package cn.tedu.back.stage.management.bookadmin.bookimport.service;

import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;

import java.util.List;

/**
 * 处理标签数据的业务接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */

public interface IBookInsertService {
    /**
     * 统计查询
     * @return 统计查询
     */
    BookListTypeVO ListTypeSelect(Long id);


    int insert(BookTypeAddNewParam bookTypeAddNewParam);

    int deleteById(Long id);

}
