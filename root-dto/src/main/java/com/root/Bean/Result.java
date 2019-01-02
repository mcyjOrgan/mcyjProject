package com.root.Bean;

import com.root.constant.ApiResultEnum;

import java.io.Serializable;

/**
 * Created by cc on 2018/3/21.
 */
public class Result<T> implements Serializable {

    private Integer code;
    private String message;
    private Integer total;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ApiResultEnum apiResultEnum, T data) {
        this(apiResultEnum.getCode(), apiResultEnum.getMessage(), data);
    }

    public Result(ApiResultEnum apiResultEnum, T data, Integer total) {
        this(apiResultEnum.getCode(), apiResultEnum.getMessage(), data, total);
    }

    public Result(ApiResultEnum apiResultEnum) {
        this(apiResultEnum.getCode(), apiResultEnum.getMessage(), null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(Integer code, String message, T data, Integer total) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
