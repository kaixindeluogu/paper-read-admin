package cn.tedu.back.stage.management.superadmin.libraryapply.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhangx
 */

@Data
@TableName(value = "zhipian_apply")
public class LibraryApply implements Serializable {
    /**
     * ID,唯一标识
     * */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     *申请内容
     * */
    private String content;
    /**
     *图片凭证
     */
    private String imgUrl;
    /**
     *状态(申请中,申请通过,不通过)
     */
    private String status;
    /**
     * 申请用户的ID
     */
    private Long userId;

    /**
     * 开始时间
     * */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     * */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
