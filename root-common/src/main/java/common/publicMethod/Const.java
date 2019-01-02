package common.publicMethod;

import org.springframework.context.ApplicationContext;

public class Const {
	
	public enum Session {  
		  USERNAME, USERID,WECHATID,CODE,CORPNAME,LOGINSTATE
		}

	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	
	public static final String SEPARATOR = "^";
	
	public static final String SERVER_STATUS = "status"; //响应状态
	public static final String SERVER_INFO = "info"; //响应状态信息
	public static final String SERVER_DESCRIPTION = "description"; //响应状态信息
	public static final String SERVER_DATA = "pdata"; //响应状态信息
	public static final String SERVER_RECNUM = "recnum";
	
	public static final String SERVER_PARAM = "param"; //响应状态信息
	public static final String SERVER_HISTORY = "history"; //响应状态信息
	public static final String SERVER_ID = "id"; //响应状态信息
	
	public static final String SERVER_STATUS_OK = "0"; //响应成功
	public static final String SERVER_STATUS_ERROR = "1"; //响应失败
	public static final String SERVER_STATUS_LOGIN_TIMEOUT = "2";//登录超时
	
	public static final String[] RETINFO_ARRAYS = {"保存成功","提交成功","更新成功","删除成功","查询成功","登录成功","退出成功","添加成功"};

	public static final String[] RETINFO_EN_DISABLE = {"已禁用","已启用"};
	
	public static final Integer SERVER_STATUS_200 = 200; //成功
	public static final Integer SERVER_STATUS_201 = 201; //已创建
	public static final Integer SERVER_STATUS_204 = 204; //没有内容
	public static final Integer SERVER_STATUS_304 = 304; //未修改
	public static final Integer SERVER_STATUS_400 = 400; //错误的请求
	public static final Integer SERVER_STATUS_401 = 401; //未授权(认证失败)
	public static final Integer SERVER_STATUS_403 = 403; //禁止访问(无权限)
	public static final Integer SERVER_STATUS_404 = 404; //未找到
	public static final Integer SERVER_STATUS_405 = 405; //方法被禁用
	public static final Integer SERVER_STATUS_410 = 410; //已删除
	public static final Integer SERVER_STATUS_415 = 415; //不支持的媒体类型(类型不支持)
	public static final Integer SERVER_STATUS_422 = 422; //无法处理的实体(新建失败)
	public static final Integer SERVER_STATUS_429 = 429; //请求过多
	
	//session 的 key
	public static final String SESSION_USER_KEY = "userinfo"; //用户信息key
	//session userinfo 信息的key， String类型
	public enum userinfo {
		userid,account,empid,cname,ename,dept,wechatid,wechatname
	}
	public static final String SESSION_AUTH_KEY = "funcinfo"; //权限信息key
	
}
