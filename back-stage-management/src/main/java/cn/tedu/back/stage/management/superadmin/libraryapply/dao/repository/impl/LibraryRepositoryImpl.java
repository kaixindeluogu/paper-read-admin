package cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.impl;

import cn.tedu.back.stage.management.superadmin.libraryapply.dao.mapper.LibraryMapper;
import cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.ILibraryRepository;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Library;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class LibraryRepositoryImpl implements ILibraryRepository {
    @Autowired
    private LibraryMapper mapper;

    public LibraryRepositoryImpl() {
        log.info("创建存储库对象：LibraryRepositoryImpl");
    }

    @Override
    public int insert(Library library) {
        log.debug("开始执行【向图书馆表中插入数据】，参数：{}", library);
        return mapper.insert(library);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }
}
