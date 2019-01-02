package com.root.Base;


import com.root.Bean.Result;
import com.root.constant.ApiResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by cc on 2018/3/21.
 */
public class BaseApiController {

    private final static Logger _log = LoggerFactory.getLogger(BaseApiController.class);

    /**
     * 统一异常处理
     *
     * @param request
     * @param response
     * @param exception
     */
    @ExceptionHandler
    public Result exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            request.setAttribute("requestHeader", "ajax");
        }
        request.setAttribute("ex", exception);
        _log.error("统一异常处理：", exception);
        return new Result(ApiResultEnum.ERR);
    }

    public <T> Result<T> getFailResult() {
        return new Result<>(ApiResultEnum.FAIL, null);
    }

}
