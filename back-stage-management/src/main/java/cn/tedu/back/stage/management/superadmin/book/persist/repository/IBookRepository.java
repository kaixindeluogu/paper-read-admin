package cn.tedu.back.stage.management.superadmin.book.persist.repository;

import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;

import java.util.List;

/**
 * 处理标签数据的存储库接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface IBookRepository {

    List<BookTypeAddNewParam> select();


//    void delete(Long id);

}
