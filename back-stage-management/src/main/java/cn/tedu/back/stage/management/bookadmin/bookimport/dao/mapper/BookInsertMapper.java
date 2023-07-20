package cn.tedu.back.stage.management.bookadmin.bookimport.dao.mapper;

import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.entity.Book;
import cn.tedu.back.stage.management.bookadmin.bookimport.pojo.vo.BookListTypeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/16 17:10
 */
@Repository
public interface BookInsertMapper extends BaseMapper<Book> {
    /**
     * 统计查询,暂未用到
     * @return 统计查询
     */
     BookListTypeVO ListTypeSelect(Long id);



}