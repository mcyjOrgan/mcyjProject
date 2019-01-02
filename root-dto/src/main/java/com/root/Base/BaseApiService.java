package com.root.Base;

import com.root.Bean.Result;
import com.root.constant.ApiResultEnum;
import com.root.dto.LrzjlResult;
import com.root.dto.LrzjlResultItem;
import com.root.dto.LrzjlResultList;

/**
 * Created by cc on 2018/3/20.
 */
public interface BaseApiService {

    <T> Result<T> getResult(LrzjlResultItem<T> lrzjlResultItem);

    <T> Result getResult(LrzjlResultList<T> lrzjlResultList);

    Result<String> getResult(LrzjlResult lrzjlResult);

    <T> Result<T> getResult(T vo);

    <T> Result<T> getResult(Integer code, String message, T vo);

    <T> Result<T> getResult(ApiResultEnum apiResultEnum, T vo);

    Result getFailResult();

    Result getFailResult(String description);

    Result getFailResult(Integer code, String message, String description);

}
