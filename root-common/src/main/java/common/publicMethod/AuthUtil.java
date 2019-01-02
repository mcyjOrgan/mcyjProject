package common.publicMethod;

import common.exception.DataException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;


public class AuthUtil {
	
	private static Logger wlogger = Logger.getLogger(AuthUtil.class);
	
	public static String getPath(HttpServletRequest request){
		String uri = request.getServletPath();
		String pathInfo = request.getPathInfo();
		if (pathInfo != null && pathInfo.length() > 0) {
		    uri = uri + pathInfo;
		}
		uri = StringUtils.substringBefore(uri,".");
		return uri.substring(1);
	}
	
	public static String getControllerPath(String path){
		String uri = StringUtils.substringBefore(path, "/");
		return uri;
	}
	
	/*判断接口权限*/
	@SuppressWarnings("unchecked")
	public static boolean checkInterAuth(String key){
		wlogger.debug(key);
		
		boolean vbool = false;
		Subject currentAuth = SecurityUtils.getSubject();  
		Session session = currentAuth.getSession();
		if (((HashMap<String,Object>)session.getAttribute(Const.SESSION_AUTH_KEY)).containsKey(key)){
			vbool = true;
		}
		return vbool;
	}
	
	/*组装返回权限给前台*/
	public static JSONArray retPageAuth(Object obj){
		JSONArray vJa = new JSONArray();
		if (null == obj){
			wlogger.debug(vJa.toString());
			return vJa;
		}
		String [] vStrs = (String[])obj;
		wlogger.debug(vStrs.toString());
		
		for (int i=0;i<vStrs.length;i++){
			JSONObject vJo = new JSONObject();
			vJo.put(vStrs[i], AuthUtil.checkInterAuth(vStrs[i]));
			vJa.add(vJo);
		}
		return vJa;
	}
	
	/* 获取session中userinfo的某个key值*/
	@SuppressWarnings("unchecked")
	public static String retUserMapValue(String key){
		wlogger.debug(key);
		
		String retVal = "";
		Subject currentAuth = SecurityUtils.getSubject();  
		Session session = currentAuth.getSession();
		
		Object obj = session.getAttribute(Const.SESSION_USER_KEY);  
        if (null != obj) {
        	Object objVal = ((HashMap<String,Object>)obj).get(key);
        	retVal = objVal == null ? "" : objVal.toString();
        }
        return retVal;
	}
	
	public static void userAuth(HttpServletRequest request) throws DataException{
		HttpSession session = request.getSession(true);  
		Object obj = session.getAttribute(Const.SESSION_USER_KEY);  
        if (obj == null) { 
        	throw new DataException(Conmanager.getConStr("LOGIN_TIMEOUT"));
    	}else{
    		String key =AuthUtil.getPath(request);
    		boolean bool = AuthUtil.checkInterAuth(key);
        	if (!bool){//接口无权限
        		throw new DataException(Conmanager.getConStr("MSG_5"));
        	}
        }
    }
	
	public static String[] userGroupAuth(ArrayList<String> groupId) {
		String[] userGroupAuth = {"",""};
		String auth_group = "",manager_group = "";
		for(int i=0;i<groupId.size();i++){
			auth_group = auth_group + ";" +"#"+groupId.get(i)+"#:read;#"+groupId.get(i)+"#:edit";
			manager_group = manager_group + ";" +"#"+groupId.get(i)+"#";
		}
		if(!"".equals(auth_group)){
			auth_group = auth_group.substring(1);
		}
		if(!"".equals(manager_group)){
			manager_group = manager_group.substring(1);
		}
		userGroupAuth[0] = auth_group;
		userGroupAuth[1] = manager_group;
		return userGroupAuth;
	}
}
