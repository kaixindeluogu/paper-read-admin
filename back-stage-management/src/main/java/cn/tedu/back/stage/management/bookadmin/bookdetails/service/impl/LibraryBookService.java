package cn.tedu.back.stage.management.bookadmin.bookdetails.service.impl;

import cn.tedu.back.stage.management.bookadmin.bookdetails.dao.repository.IListLibraryBookRepository;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.entiy.Book;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.param.LibraryBookParam;
import cn.tedu.back.stage.management.bookadmin.bookdetails.pojo.vo.LibraryBookVO;
import cn.tedu.back.stage.management.bookadmin.bookdetails.service.ILibraryBookService;
import cn.tedu.back.stage.management.common.ex.ServiceException;
import cn.tedu.back.stage.management.common.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

/**
 * Author = bianmy
 * DATE = 2023/6/23 21:07
 */
@Slf4j
@Service
public class LibraryBookService implements ILibraryBookService {

    @Autowired
    private IListLibraryBookRepository libraryBookRepository;
    @Override
    public List<LibraryBookVO> ListLibraryBook(Long id) throws IOException {
        log.info("查询图书店铺id业务传入{}",id);
        if (id == null) {
            String message = "删除失败,请检查您是否登录或图书是否存在!";
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND,message);
        }
        List<LibraryBookVO> libraryBookVOS = libraryBookRepository.listLibraryBook(id);


//        /**
//         在上述代码中，使用了 Java 8 中新增的 Base64 类来进行编码和解码。
//         其中，Base64.getEncoder().encodeToString(imageBytes)
//         方法用于将字节数组转换成 base64 编码的字符串。
//         需要注意的是，该方法返回的字符串不包含前缀 data:image/png;base64,，
//         需要在返回给前端时手动添加.
//         *
//         * */
//        for (LibraryBookVO libraryBookVO: libraryBookVOS){
//            Path imagePath = Paths.get("e:/files/" + libraryBookVO.getCover());
//            byte[] imageBytes = Files.readAllBytes(imagePath);
//            // 将图片转换成 base64 编码
//            String base64Img = Base64.getEncoder().encodeToString(imageBytes);
//            libraryBookVO.setCover("data:image/png;base64," + base64Img);
//        }
        return libraryBookVOS;
    }

    @Override
    public void deleteBookById(Long id) {
        log.info("删除图书店铺id业务传入{}",id);
        if (id == null) {
            String message = "删除失败,请检查图书是否存在!";
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND,message);
        }
        libraryBookRepository.deleteBookById(id);
    }

    @Override
    public void updateBookById(LibraryBookParam libraryBookParam) {
        log.info("修改图书店铺Param对象业务传入{}",libraryBookParam);
        Book selectBook = libraryBookRepository.selectBookById(libraryBookParam.getId());
        log.info("修改图书店铺Book对象业务传入{}",selectBook);
        if (selectBook == null) {
            String message = "删除失败,请检查图书是否存在!";
            throw new ServiceException(ServiceCode.ERROR_NOT_FOUND,message);
        }
        Book book = new Book();
        BeanUtils.copyProperties(libraryBookParam, book);
        log.info("最后修改的book对象{}",book);
        libraryBookRepository.updateBookById(book);
    }

    @Override
    public Book selectParamById(Long id) {
        log.info("查询图书店铺修改按钮id业务传入{}",id);
        return libraryBookRepository.selectBookById(id);
    }


}