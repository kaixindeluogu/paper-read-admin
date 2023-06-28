package cn.tedu.back.stage.management.bookadmin.librarydatastatistics.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LibraryDataStatisticsListItemVO {

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
}
