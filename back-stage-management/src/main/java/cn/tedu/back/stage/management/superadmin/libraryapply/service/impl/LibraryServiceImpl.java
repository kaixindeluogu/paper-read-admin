package cn.tedu.back.stage.management.superadmin.libraryapply.service.impl;

import cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.ILibraryRepository;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Library;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.LibraryAddNewParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.service.ILibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class LibraryServiceImpl implements ILibraryService {
    @Autowired
    private ILibraryRepository libraryRepository;

    public LibraryServiceImpl() {
        log.info("创建业务对象：LibraryServiceImpl");
    }
    @Override
    public void addNew(LibraryAddNewParam libraryAddNewParam) {
        log.debug("开始处理新增图书馆业务, 参数:{} ", libraryAddNewParam);
        Library library=new Library();
        BeanUtils.copyProperties(libraryAddNewParam,library);
        library.setClickNum(0);
        libraryRepository.insert(library);

    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除标签】的业务，参数：{}", id);
        libraryRepository.deleteById(id);
    }
}
