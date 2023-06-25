package cn.tedu.back.stage.management.superadmin.book.service;

import cn.tedu.back.stage.management.common.pojo.vo.PageData;
import cn.tedu.back.stage.management.superadmin.book.pojo.param.BookTypeAddNewParam;
import cn.tedu.back.stage.management.superadmin.book.pojo.vo.BookStandardVO;
import cn.tedu.back.stage.management.superadmin.report.pojo.vo.ReportListItemVO;

import java.util.List;

/**
 * 处理标签数据的业务接口
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public interface IBookService {

    /**
     * 根据 id 查询
     * @param id 书籍id
     * @return 根据 id 查询
     */
    BookStandardVO selectBooksByIdNotZero(Long id);


    /**
     * 删除标签
     *
     * @param id 尝试删除的标签的ID
     */
    void delete(Long id);

    /**
     * 查询举报信息列表
     *
     * @param pageNum  页码
     * @param pageSize 每条记录数
     * @return 举报信息列表的分页数据
     */
    PageData<BookStandardVO> listType(Integer pageNum, Integer pageSize);

    /**
     * 查询举报信息列表，将使用默认的“每页记录数”
     *
     * @param pageNum  页码
     * @return 举报信息列表的分页数据
     */
    PageData<BookStandardVO> listType(Integer pageNum);
}
