package com.eliteams.quick4j.web;

import com.root.Base.BaseApiController;
import common.util.PropertiesUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SessionControllerApi extends BaseApiController {

    private final Logger logger = LoggerFactory.getLogger(SessionControllerApi.class);

    private static PropertiesUtil propertiesUtil = PropertiesUtil.getInstance("application");
    private static String themenuJson = propertiesUtil.get("log.menu");


    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    protected void removeSession() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.removeAttribute("userInfo");
        subject.logout();
    }



}
