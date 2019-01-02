package com.root.Base;

import com.root.Bean.Result;
import com.root.constant.ApiResultEnum;
import com.root.dto.LrzjlResult;
import com.root.dto.LrzjlResultItem;
import com.root.dto.LrzjlResultList;
import common.base.BaseServiceImpl;

import java.util.List;

/**
 * Created by cc on 2018/3/21.
 */
public class BaseApiServiceImpl extends BaseServiceImpl implements BaseApiService {

    @Override
    public <T> Result<T> getResult(LrzjlResultItem<T> lrzjlResultItem) {
        if (null != lrzjlResultItem) {
            T item = lrzjlResultItem.getItem();
            Integer code = lrzjlResultItem.getCode();
            String message = lrzjlResultItem.getMessage() + lrzjlResultItem.getDescription();
            return new Result<>(code, message, item);
        } else {
            return new Result<>(ApiResultEnum.ERR, null);
        }
    }

    @Override
    public <T> Result<List<T>> getResult(LrzjlResultList<T> lrzjlResultList) {
        if (null != lrzjlResultList) {
            List<T> item = lrzjlResultList.getItemList();
            Integer code = lrzjlResultList.getCode();
            String message = lrzjlResultList.getMessage() + lrzjlResultList.getDescription();
            Integer total = lrzjlResultList.getCount();
            return new Result<>(code, message, item, total);
        } else {
            return new Result<>(ApiResultEnum.ERR, null);
        }
    }

    @Override
    public Result<String> getResult(LrzjlResult lrzjlResult) {
        if (null != lrzjlResult) {
            String description = lrzjlResult.getDescription();
            Integer code = lrzjlResult.getCode();
            String message = lrzjlResult.getMessage();
            return new Result<>(code, message, description);
        } else {
            return new Result<>(ApiResultEnum.ERR, null);
        }
    }

    @Override
    public <T> Result<T> getResult(T vo) {
        return new Result<>(ApiResultEnum.SUCCESS, vo);
    }

    @Override
    public <T> Result<T> getResult(Integer code, String message, T vo) {
        return new Result<>(code, message, vo);
    }

    @Override
    public <T> Result<T> getResult(ApiResultEnum apiResultEnum, T vo) {
        return new Result<>(apiResultEnum.getCode(), apiResultEnum.getMessage(), vo);
    }

    @Override
    public Result<String> getFailResult() {
        return new Result<>(ApiResultEnum.FAIL, null);
    }

    @Override
    public Result getFailResult(String description) {
        return new Result(ApiResultEnum.FAIL, null);
    }

    @Override
    public Result getFailResult(Integer code, String message, String description) {
        return new Result<>(code, message, description);
    }
}
