package cn.tedu.back.stage.management.superadmin.libraryapply.service.impl;

import cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository.ILibraryApplyRepository;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.LibraryApply;
import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.LibraryApplyAddNewParam;
import cn.tedu.back.stage.management.superadmin.libraryapply.service.ILibraryApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LibraryApplyServiceImpl implements ILibraryApplyService {
    @Autowired
    private ILibraryApplyRepository repository;

    @Override
    public void addNew(LibraryApplyAddNewParam libraryApplyAddNewParam) {
        log.debug("开始处理新增图书馆业务, 参数:{} ", libraryApplyAddNewParam);

        LibraryApply libraryApply=new LibraryApply();
        BeanUtils.copyProperties(libraryApplyAddNewParam,libraryApply);
        libraryApply.setStatus("审核通过");
        repository.insert(libraryApply);

    }
}
