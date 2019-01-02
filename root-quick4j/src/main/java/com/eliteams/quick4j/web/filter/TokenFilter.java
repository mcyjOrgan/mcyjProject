package com.eliteams.quick4j.web.filter;

import com.alibaba.fastjson.JSON;
import com.root.Bean.Result;
import com.root.constant.ApiResultEnum;
import common.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by cc on 2018/3/22.
 */
public class TokenFilter implements Filter {

    private static Logger _log = LoggerFactory.getLogger(Filter.class);
    private CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean requestType = true;
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "content-type,access-token,From,*");
            response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
            //            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            String contentType = request.getContentType();//获取请求的content-type
            Map<String, MultipartFile> fileMap;
            MockHttpServletRequest mockHttpServletRequest;
            if (contentType != null && contentType.contains("multipart/form-data")) {//文件上传请求 *特殊请求
                requestType = false;
                request = multipartResolver.resolveMultipart(request);//将转化后的reuqest赋值到过滤链中的参数 *重要
                fileMap = ((MultipartHttpServletRequest) request).getFileMap();
                mockHttpServletRequest = new MockMultipartHttpServletRequest();
                mockHttpServletRequest.setMethod(request.getMethod());
                mockHttpServletRequest.setRequestURI(request.getRequestURI());
                for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
                    MultipartFile file = entity.getValue();
                    ((MockMultipartHttpServletRequest) mockHttpServletRequest).addFile(file);
                    mockHttpServletRequest.setContent(file.getBytes());
                }
            } else {
                mockHttpServletRequest = new MockHttpServletRequest(request.getMethod(), request.getRequestURI());
            }
            ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
//        copy uri
            //MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest(request.getMethod(), request.getRequestURI());
//        copy local param
            String body = RequestHelp.getBodyString(requestWrapper);
            mockHttpServletRequest.setLocalPort(request.getLocalPort());
            mockHttpServletRequest.setLocalName(request.getLocalName());
            mockHttpServletRequest.setLocalAddr(request.getLocalAddr());
//        copy remote param
            mockHttpServletRequest.setRemotePort(request.getRemotePort());
            mockHttpServletRequest.setRemoteAddr(request.getRemoteAddr());
            mockHttpServletRequest.setRemoteHost(request.getRemoteHost());
//        copy server param
            mockHttpServletRequest.setServerPort(request.getServerPort());
            mockHttpServletRequest.setServerName(request.getServerName());
            mockHttpServletRequest.setServletPath(request.getServletPath());
//        copy paramMap
            Map<String, String[]> parameterMap = request.getParameterMap();
            mockHttpServletRequest.addParameters(parameterMap);
            if (requestType) {
                mockHttpServletRequest.setContent(body.getBytes("utf-8"));
            }
//        copy header
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String header = request.getHeader(headerName);
                mockHttpServletRequest.addHeader(headerName, header);
            }
//        verify token
//            String token = request.getHeader("access-token");
//            if (!StringUtils.isEmpty(token)) {
//                try {
//                    Long opId = TokenUtil.verifyToken(token).getClaim("opId").asLong();
//                    Long opType = TokenUtil.verifyToken(token).getClaim("opType").asLong();
//                    mockHttpServletRequest.addParameter("opId", opId.toString());
//                    mockHttpServletRequest.addParameter("opType", opType.toString());
//
//                    String from = request.getHeader("From");
//                    if(from!=null&&!"".equals(from)){
//                        mockHttpServletRequest.addParameter("From",from);
//                    }else{
//                        mockHttpServletRequest.addParameter("From","2");
//                    }
//
//
//                } catch (Exception e) {
//                    _log.error("token verify error", e);
//                }
//            }
            filterChain.doFilter(mockHttpServletRequest, servletResponse);
        } catch (Exception e) {
            _log.error("IO or Servlet Error", e);
            returnFail(response);
        }
    }


    @Override
    public void destroy() {

    }

    private void returnFail(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
            PrintWriter writer = httpServletResponse.getWriter();
            Result result = new Result(ApiResultEnum.ERR);
            String resultJson = JSON.toJSONString(result);
            writer.print(resultJson);
        } catch (IOException e) {
            _log.error("IO Error", e);
        }
    }
}
