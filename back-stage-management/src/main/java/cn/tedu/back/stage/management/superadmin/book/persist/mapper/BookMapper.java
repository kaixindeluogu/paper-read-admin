package cn.tedu.back.stage.management.superadmin.book.persist.mapper;

import cn.tedu.back.stage.management.superadmin.book.pojo.entity.Book;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理标签数据的Mapper接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {

    /**
     * 根据 id 查询
     * @param id 书籍id
     * @return 根据 id 查询
     */
    BookStandardVO selectBooksByIdNotZero(Long id);


    /**
     * 查询书籍列表
     * @return 查询书籍列表
     */
    List<BookStandardVO> listType();

}