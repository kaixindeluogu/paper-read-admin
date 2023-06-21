package cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.impl;

import cn.tedu.back.stage.management.superadmin.libraryapply.dao.mapper.LibraryApplyMapper;
import cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.ILibraryApplyRepository;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.LibraryApply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class LibraryApplyRepositoryImpl implements ILibraryApplyRepository {
    @Autowired
    private LibraryApplyMapper mapper;

    public LibraryApplyRepositoryImpl(){
        log.info("创建存储库对象:LibraryApplyRepositoryImpl");
    }




    @Override
    public int insert(LibraryApply libraryApply) {

        log.debug("向图书馆插入数据"+libraryApply);
        return mapper.insert(libraryApply);
    }




}
