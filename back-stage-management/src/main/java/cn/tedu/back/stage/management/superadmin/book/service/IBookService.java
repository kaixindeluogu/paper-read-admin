package cn.tedu.back.stage.management.superadmin.book.service;

import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;

import java.util.List;

/**
 * 处理标签数据的业务接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface IBookService {
    List<BookTypeAddNewParam> selectType();


}
