package cn.tedu.back.stage.management.superadmin.libraryapply.pojo.param;

import lombok.Data;

@Data
public class LibraryApplyAddNewParam {


    /**
     *申请内容
     * */
    private String content;
    /**
     *图片凭证
     */
    private String imgUrl;

    /**
     * 申请用户的ID
     */
    private Long userId;
}
