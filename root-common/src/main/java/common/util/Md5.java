package common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class Md5 {

	private static Logger wlogger = Logger.getLogger(Md5.class);
	
	//加密encryption  ---   
	public static String encryp(String inStr){
		String retstr = "";
		try {
			byte[] byteArray = inStr.getBytes("UTF-8");
			retstr = DigestUtils.md5Hex(byteArray);
		}catch(Exception e){
			wlogger.error(e.getMessage());
		}
		return retstr;
	}
}
