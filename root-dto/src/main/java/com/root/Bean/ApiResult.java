package com.root.Bean;

import com.root.constant.ApiResultEnum;
import common.base.BaseResult;

import java.io.Serializable;

/**
 * api系统常量枚举类
 * Created by shuzheng on 2017/2/19.
 */
public class ApiResult extends BaseResult implements Serializable {

    public ApiResult() {
    }

    public ApiResult(int code, String message, Object data) {
        super(code, message, data);
    }

    public ApiResult(ApiResultEnum apiResultEnum, Object data) {
        super(apiResultEnum.getCode(), apiResultEnum.getMessage(), data);
    }
    public ApiResult(ApiResultEnum apiResultEnum) {
        super(apiResultEnum.getCode(), apiResultEnum.getMessage());
    }

}
