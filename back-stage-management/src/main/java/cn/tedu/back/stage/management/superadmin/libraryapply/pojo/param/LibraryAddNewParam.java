package cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LibraryAddNewParam {

    /**
     * 图书馆名称
     */
    private String name;
    /**
     * 图书馆地址
     */
    private String address;
    /**
     * 借阅规则
     */
    private String rule;
}
