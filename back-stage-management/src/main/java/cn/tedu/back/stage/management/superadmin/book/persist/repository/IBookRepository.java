package cn.tedu.back.stage.management.superadmin.book.persist.repository;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;

import java.util.List;

/**
 * 处理标签数据的存储库接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface IBookRepository {


    /**
     * 根据ID书籍信息
     *
     * @param id 尝试删除的书籍信息的ID
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据 id 查询
     * @param id 书籍id
     * @return 根据 id 查询
     */
    BookStandardVO selectBooksByIdNotZero(Long id);


    /**
     * 查询书籍信息列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 书籍信息列表的分页数据
     */
    PageData<BookStandardVO> listType(Integer pageNum, Integer pageSize);







}
