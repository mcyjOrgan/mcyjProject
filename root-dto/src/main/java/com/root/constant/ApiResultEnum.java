package com.root.constant;

/**
 * api系统接口结果常量枚举类
 * Created by cc on 2018/3/20.
 */
public enum ApiResultEnum {

    SUCCESS(200, "success"),
    FAIL(205, "fail"),
    NOT_FOUND(404, "not found"),
    TOKEN_INVALID(230001, "用户信息验证失败"),
    THROWABLE_PARAM(230002, "参数验证失败"),
    UNEXPECTED_RESULT(230003, "获取数据异常"),
    DUPLICATION_OF_DATA(230004, "记录已存在"),
    EXIST(230005, "该信息被引用中，无法删除"),
    ERR_OF_DATA(230006, "数据有误，联系系统管理员查看"),

    ERROR_TOKRN(508, "非法的token"),
    OVER_TOKEN(514, "过期的token"),
    ERR(500, "未知错误，请稍后再试"),


    //====API接口返回码=====
    OK(0,"执行成功"),
    TIME_OUT(-1,"连接超时"),
    SIGN_ERROR(-2,"签名错误"),
    DATA_ERROR(-3,"应用参数错误"),
    SYS_ERROR(-4,"执行异常"),
    NOT_FIND_THREE(-5,"找不到第三方信息"),
    DECRYPE_ERROR(-6,"数据解密失败");
    //====API接口返回码=====

    public Integer code;

    public String message;

    ApiResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
