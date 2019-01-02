package com.eliteams.quick4j.web.security;

import com.eliteams.quick4j.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户身份验证,授权 Realm 组件
 *
 * @author cc
 * @since 2018年4月120日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;



    /**
     * 权限检查
     * @param principals 用户权限标识
     * @return AuthorizationInfo 用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }

    /**
     * 登录验证
     *
     * @param token 用户接口调用便是
     * @return AuthenticationInfo
     * @throws AuthenticationException 用户名或密码错误
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *
     * @see Session
     */
    private void setSession(Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            session.setAttribute("userInfo", value);
        }
    }

}
