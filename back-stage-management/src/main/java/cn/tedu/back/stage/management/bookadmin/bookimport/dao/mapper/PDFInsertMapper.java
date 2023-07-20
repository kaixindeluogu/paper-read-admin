package cn.tedu.back.stage.management.bookadmin.bookimport.dao.mapper;

import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.PDFData;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * PDF表相关数据库操作
 * Author = bianmy
 * DATE = 2023/6/16 17:10
 */
@Repository
public interface PDFInsertMapper extends BaseMapper<PDFData> {

    /**
     * 根据上传的url路径获取到图书ID,修改PDF的BookID
     */

    void updateByCover(BookTypeAddNewParam book);

}