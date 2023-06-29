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
     * zhipian_library图书馆名
     */
    private String name;
    /**
     * zhipian_category 图书分类
     */
    private Integer categoryId;
    /**
     *zhipian_book 书籍库存量
     */
    private Integer storeAmount;
    /**
     * zhipian_book 借阅量
     */
    private Integer borrowingVolume;
    /**
     * zhipian_library 图书馆点击量
     */
    private Long clickNum;
}
