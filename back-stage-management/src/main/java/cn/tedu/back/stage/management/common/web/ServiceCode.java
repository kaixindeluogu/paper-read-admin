package cn.tedu.back.stage.management.common.web;

/**
 * 业务状态码
 *
 * @author java@tedu.cn
 * @version 1.0
 */
public enum ServiceCode {

    /**
     * 操作成功
     */
    OK(20000),
    /**
     * 错误：请求参数格式错误
     */
    ERROR_BAD_REQUEST(40000),
    /**
     * 错误：数据不存在
     */
    ERROR_NOT_FOUND(40400),
    /**
     * 错误：数据冲突
     */
    ERROR_CONFLICT(40900),
    /**
     *
     * 删除失败
     * */
    DELETE_ERROR(49999),
/**
 * IO异常
 * */
    IO_ERROR(50000),
    /**
     * 错误：未知的修改数据失败
     */
    ERROR_UPDATE(50200),
    /**
     * 错误：其它异常
     */
    ERROR_UNKNOWN(99999);

    private Integer value;

    ServiceCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
