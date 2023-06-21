package cn.tedu.back.stage.management.superadmin.libraryapply.service;

import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param.LibraryAddNewParam;

public interface ILibraryService {
    void addNew(LibraryAddNewParam libraryAddNewParam);

    /**
     * 删除标签
     * @param id
     */
    void delete(Long id);
}
