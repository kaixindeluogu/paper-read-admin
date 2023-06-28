package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "zhipian_datastatistics")
public class LibraryDataStatistics {
    /**
     * 数据id
     */
    @TableId(type= IdType.AUTO)
    private Long id;
    /**
     * 图书馆名
     */
    private String name;
    /**
     * 图书分类
     */
    private Integer categoryId;
    /**
     *书籍库存量
     */
    private Integer storeAmount;
    /**
     * 借阅量
     */
    private Integer borrowingVolume;
    /**
     * 数据创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 数据最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
