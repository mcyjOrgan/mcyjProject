package common.publicMethod;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author z00012
 * 
 * 读取连接配置Bean
 *
 */
@Service
public class Conmanager {
	
	/**
	 * @param key
	 * @return
	 * 
	 * 根据输入的key值获取propertis的value
	 * 
	 */
	public static String getConStr(String key){
		String result = "";
		Properties prop = new Properties();
		 //读取属性文件a.properties
		try {        
			prop.load(new InputStreamReader(Conmanager.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8")); 
			//InputStream in = this.getClass().getResourceAsStream("/config.properties");//new BufferedInputStream (new FileInputStream("link.properties"));
			//prop.load(in);
			result = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @param key
	 * @return
	 * 
	 * 根据输入的key值获取propertis的value(取^前的数据)
	 * 
	 */
	public static String getConCodeFStr(String key,String separator){
		String result = "";
		Properties prop = new Properties();
		 //读取属性文件a.properties
		try {        
			prop.load(new InputStreamReader(Conmanager.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8")); 
			//InputStream in = this.getClass().getResourceAsStream("/config.properties");//new BufferedInputStream (new FileInputStream("link.properties"));
			//prop.load(in);
			result = prop.getProperty(key);
			result = StringUtils.substringBefore(result, separator);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @param key
	 * @return
	 * 
	 * 根据输入的key值获取propertis的value(取^后的数据)
	 * 
	 */
	public static String getConCodeAStr(String key,String separator){
		String result = "";
		Properties prop = new Properties();
		 //读取属性文件a.properties
		try {        
			prop.load(new InputStreamReader(Conmanager.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8")); 
			//InputStream in = this.getClass().getResourceAsStream("/config.properties");//new BufferedInputStream (new FileInputStream("link.properties"));
			//prop.load(in);
			result = prop.getProperty(key);
			result = StringUtils.substringAfter(result, separator); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
