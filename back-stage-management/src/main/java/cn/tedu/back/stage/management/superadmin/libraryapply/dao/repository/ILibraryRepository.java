package cn.tedu.back.stage.management.superadmin.libraryapply.dao.repository;

import cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity.Library;

public interface ILibraryRepository {
    int insert(Library library);

    /**
     * 根据ID删除标签数据
     *
     * @param id 尝试删除的标签的ID
     * @return 受影响的行数
     */
    int deleteById(Long id);
}
