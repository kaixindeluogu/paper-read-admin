package cn.tedu.back.stage.management.bookadmin.bookimport.dao.repository;

import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.PDFData;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;


/**
 *
 * Author = bianmy
 * DATE = 2023/7/10 23:38
 */
public interface IPDFRepository {
    /**
     * 插入PDF数据
     */
    void insert(PDFData data);


    /**
     * 根据上传的url路径获取到图书ID,修改PDF的BookID
     */

    void updateByCover(BookTypeAddNewParam book);
}