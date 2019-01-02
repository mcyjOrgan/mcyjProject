package com.root.constant;


import com.root.Bean.ApiResult;
import com.root.dto.LrzjlResult;
import com.root.dto.LrzjlResultItem;
import com.root.dto.LrzjlResultList;

/**
 * 返回值转换工具
 * Created by shusican on 17/7/11.
 */
public class ConvertResultUtil {

    public static ApiResult convert(LrzjlResultItem lrzjlResultItem) {
        Integer code = lrzjlResultItem.getCode();
        Object data = lrzjlResultItem.getItem();
        String message = lrzjlResultItem.getMessage() + ",description:" + lrzjlResultItem.getDescription();
        return new ApiResult(code, message, data);
    }

    public static ApiResult convert(LrzjlResultList lrzjlResultList) {
        Integer code = lrzjlResultList.getCode();
        Object data = lrzjlResultList.getItemList();
        String message = lrzjlResultList.getMessage() + ",description:" + lrzjlResultList.getDescription();
        return new ApiResult(code, message, data);
    }

    public static ApiResult convert(LrzjlResult lrzjlResult) {
        Integer code = lrzjlResult.getCode();
        String message = lrzjlResult.getMessage();
        String data = lrzjlResult.getDescription();
        return new ApiResult(code, message, data);
    }
}
