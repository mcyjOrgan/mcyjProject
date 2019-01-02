package common.publicMethod;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonUtil {
	
	private static Logger wlogger = Logger.getLogger(CommonUtil.class);
	
	//生成唯一编号UUID
	private static String getUUIDString() {
        UUID uuid = UUID.randomUUID();
        String a = uuid.toString().replaceAll("-", "");
        return a;
    }
	
	/*
	 * 获取随机数
	 * @return String
	 */
	 public static String getNonce() {
	    Random random = new Random();
	    return new Md5Hash(String.valueOf(random.nextInt(10000))).toString();
	    //return Md5EAD.md5Encode(String.valueOf(random.nextInt(10000)));
	  }
	 
	 /*
	 * 获取时间戳
	 * @return String
	 */
	  public static String getTimeStamp() {
	    return String.valueOf(System.currentTimeMillis() / 1000);
	  }
	  
	  /*
	   * 获取当前系统时间(带格式)
	   * @return String
	   */
	  public static String getCurrTime(String pFormat){
		  SimpleDateFormat df = new SimpleDateFormat(pFormat);//设置日期格式
		  return df.format(new Date());

	  }
	  
	  /**
	   * 字符在字符串中出现的次数
	   * 
	   * @param string
	   * @param a
	   * @return
	   */
	  public static int occurTimes(String string, String a) {
	      int pos = -2;
	      int n = 0;
	   
	      while (pos != -1) {
	          if (pos == -2) {
	              pos = -1;
	          }
	          pos = string.indexOf(a, pos + 1);
	          if (pos != -1) {
	              n++;
	          }
	      }
	      return n;
	  }
	  
	  public static String[] getArraySubName(String pStr){
		  String[] retArray = {"",""};
		  int mpos = pStr.indexOf("[")+1;
		  int npos = pStr.indexOf("]");
		  retArray[0] = pStr.substring(mpos,npos);
		  String vStr = pStr.substring(npos+1);
		  retArray[1] = vStr.substring(vStr.indexOf("[")+1, vStr.indexOf("]"));
		  return retArray;
	  }
	  
	  public static String[] getArraySubName1(String pStr){
		  String[] retArray = {"",""};
		  int mpos = pStr.indexOf("[")+1;
		  int npos = pStr.indexOf("]");
		  retArray[0] = pStr.substring(mpos,npos);
		  //String vStr = pStr.substring(npos+1);
		  //retArray[1] = vStr.substring(vStr.indexOf("[")+1, vStr.indexOf("]"));
		  return retArray;
	  }	
	  
	  //String[] 转化 Integer[]
	  public static Integer[] IntArrayTranStrArray(String[] pStrs){
		  Integer[] retArray = new Integer[pStrs.length];
		  for (int i=0;i<pStrs.length;i++){
			  retArray[i] = Integer.parseInt(pStrs[i]);
		  }
		  return retArray;
	  }
	  
	  //object转化为String
	  public static String ObjectTranString(Object pObj){
		  return null == pObj ? null : pObj.toString();
	  }
	  
	//object转化为Byte
      public static Byte ObjectTranByte(Object pObj){
          return null == pObj || pObj.toString().isEmpty() ? null : Byte.parseByte(pObj.toString());
      }
      
    //object转化为Short
      public static Short ObjectTranShort(Object pObj){
          return null == pObj || pObj.toString().isEmpty() ? null : Short.parseShort(pObj.toString());
      }
	  
	  //object转化为Integer
	  public static Integer ObjectTranInteger(Object pObj){
		  return null == pObj || pObj.toString().isEmpty() ? null : Integer.parseInt(pObj.toString());
	  }
	  
	  //object转化为Long
	  public static Long ObjectTranLong(Object pObj){
		  return null == pObj || pObj.toString().isEmpty() ? null : Long.parseLong(pObj.toString());
	  }
	
	public static HashMap<String,Object> requestParams(HttpServletRequest request) {
		HashMap<String,Object> returnMap = new HashMap<String,Object>(); 
		//判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
			Map<String, String[]> properties = request.getParameterMap();
			Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator(); 
			Entry<String, String[]> entry;
			String name = "";  
			Object value = "";  
			String rename = "";
			String[] arrname = {"",""};
			ArrayList<Object> arrayObj = new ArrayList<Object>();
			JSONObject mapObj = new JSONObject();
			int type = -1;
			while (entries.hasNext()) {
				value = ""; 
				entry = entries.next(); 
				name = entry.getKey();
				if(2 == occurTimes(name,"[") && 2 == occurTimes(name,"]")){
					if(!rename.equals(name.substring(0, name.indexOf("[")))){
						if(!rename.isEmpty()){
							if (0 == type){//数组（数组内元素是json对象）
								arrayObj.add(mapObj.toString());
								returnMap.put(rename, arrayObj.toArray(new String[arrayObj.size()]));
								arrayObj.clear();
							}else if (1 == type){//json对象
								returnMap.put(rename, mapObj.toString()); 	
							}	
						}
						type = 0;
						arrname = getArraySubName(name);
						mapObj.clear();
						rename = name.substring(0, name.indexOf("["));
					}else{
						String[] varr = getArraySubName(name);
						if (!arrname[0].equals(varr[0])){
							arrayObj.add(mapObj.toString());
							mapObj.clear();
							arrname[0] = varr[0];
						}
						arrname[1] = varr[1];
					}
				}else if(1 == occurTimes(name,"[") && 1 == occurTimes(name,"]") && -1 == name.indexOf("[]")){
					if(!rename.equals(name.substring(0, name.indexOf("[")))){
						if(!rename.isEmpty()){
							if (0 == type){//数组（数组内元素是json对象）
								arrayObj.add(mapObj.toString());
								returnMap.put(rename, arrayObj.toArray(new String[arrayObj.size()]));
								arrayObj.clear();
							}else if (1 == type){//json对象
								returnMap.put(rename, mapObj.toString()); 	
							}	
						}
						type = 1;
						arrname = getArraySubName1(name);
						mapObj.clear();
						rename = name.substring(0, name.indexOf("["));
					}else{
						String[] varr = getArraySubName1(name);
						arrname[0] = varr[0];
					}
				}else{
					if(!rename.isEmpty()){
						if (0 == type){//数组（数组内元素是json对象）
							arrayObj.add(mapObj.toString());
							returnMap.put(rename, arrayObj.toArray(new String[arrayObj.size()]));
							arrayObj.clear();
						}else if (1 == type){//json对象
							returnMap.put(rename, mapObj.toString()); 	
						}
						mapObj.clear();
						arrname[0] = "";
						arrname[1] = "";
						rename = "";
					}
				}
				Object valueObj = entry.getValue(); 
				if(null == valueObj){ 
					value = ""; 
				} else if("count".equals(name)){
					if(null!=valueObj && !"".equals(valueObj)){
						value = Integer.parseInt(((String[])valueObj)[0]);
					}else{
						value = valueObj;
					}
				} else if(valueObj instanceof String[]){ 
					String[] values = (String[])valueObj;
					if (name.indexOf("[]") > -1){
						name = name.substring(0, name.length()-2);
						value = values;
					}else if(2 == occurTimes(name,"[") && 2 == occurTimes(name,"]")){
						mapObj.put(arrname[1], values[0]);
					}else if(1 == occurTimes(name,"[") && 1 == occurTimes(name,"]") && -1 == name.indexOf("[]")){
						mapObj.put(arrname[0], values[0]);
					}else {
						value = values[0];
					}
//					for(int i=0;i<values.length;i++){ 
//						 value = values[i] + ",";
//					}
//					value = value.toString().substring(0, value.toString().length()-1);
				}else{
					value = valueObj.toString(); 
				}
				if(!(2 == occurTimes(name,"[") && 2 == occurTimes(name,"]")) &&
				   !(1 == occurTimes(name,"[") && 1 == occurTimes(name,"]") && -1 == name.indexOf("[]"))){
					returnMap.put(name, value); 
				}
			}
			if(!rename.isEmpty()){
				if (0 == type){//数组（数组内元素是json对象）
					arrayObj.add(mapObj.toString());
					returnMap.put(rename, arrayObj.toArray(new String[arrayObj.size()]));
					arrayObj.clear();
				}else if (1 == type){//json对象
					returnMap.put(rename, mapObj.toString()); 	
				}
				mapObj.clear();
				arrname[0] = "";
				arrname[1] = "";
				rename = "";
			}
		}else{
			returnMap = getFileRequestParams(request);
		}
		returnMap = addPageParams(returnMap);
		return returnMap;
	}
	
	/**
	 * 文件上传 request:form表单
	 * 
	 * @throws Exception
	 */
	private static HashMap<String,Object> getFileRequestParams(HttpServletRequest request) {
		HashMap<String,Object> returnMap = new HashMap<String,Object>(); 
		String[] imgPath = {"","",""};
		String filepath = "";
		String fileRelPath = "";		
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dayFile = new SimpleDateFormat("yyyy-MM-dd");
			String savePath = request.getServletContext().getRealPath("/upload/"+dayFile.format(date));// 输入流保存文件
			File file = new File(savePath);
			// 判断上传文件的保存目录是否存在
			if (!file.exists() && !file.isDirectory()) {
				System.out.println(savePath + "目录不存在，需要创建");
				// 创建目录
				file.mkdirs();
			}
			String vfilename = CommonUtil.getUUIDString();
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// threshold 极限、临界值，即硬盘缓存 1M (不设置默认为10k)
			// factory.setSizeThreshold(1 * 1024 * 1024);
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);   
			// 设置允许上传的最大文件大小 1G
			upload.setSizeMax(2*1024 * 1024 * 1024);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = "";
					value = item.getString("UTF-8");
					returnMap.put(name, value);
				} else {// 如果fileitem中封装的是上传文件
						// 得到上传的文件名称，
					try {
						String filename = item.getName();
						if (filename == null || filename.trim().equals("")) {
							continue;
						}
						imgPath[2] = filename;
						// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
						// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
						// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
						String filetype = filename.substring(filename.lastIndexOf("."));
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						// 获取item中的上传文件的输入流
						filename = vfilename +filetype;
						InputStream in = item.getInputStream();

						// 创建一个文件输出流
						FileOutputStream out = new FileOutputStream(savePath+ "\\" + filename);

						// 创建一个缓冲区
						byte buffer[] = new byte[1024 * 10];
						// 判断输入流中的数据是否已经读完的标识
						int len = 0;
						// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
						while ((len = in.read(buffer)) > 0) {
							// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
							out.write(buffer, 0, len);
						}
						out.flush();
						// 关闭输入流
						in.close();
						// 关闭输出流
						out.close();
						// 删除处理文件上传时生成的临时文件
						item.delete();
						String mappath = request.getServletContext().getContextPath();
						filepath = mappath + "/upload/"+dayFile.format(date)+"/"+ filename;
						fileRelPath = request.getServletContext().getRealPath("/upload/"+dayFile.format(date))+ "\\"+ filename;
						fileRelPath = fileRelPath.replace("\\", "\\\\");
						imgPath[0]=filepath;
						imgPath[1]=fileRelPath;
					} catch (Exception e) {
						wlogger.error(e.getMessage());
					} catch (Error er) {
						wlogger.error(er.getMessage());
					}
				}
			}
		} catch (Exception e) {
			wlogger.error(e.getMessage());
		}catch(Error e1){
			wlogger.error(e1.getMessage());
		}
		if(!"".equals(imgPath[1])){
			returnMap.put("picUrl", imgPath[0]);
			returnMap.put("picRelUrl", imgPath[1]);
			returnMap.put("picName", imgPath[2]);
		}
		return returnMap;
	}
	
	/*删除图片*/
	public static void ImgDel(String src){
		try {
			File f = new File(src);
			if(f.exists()){
				f.delete();
			}
		} catch (Exception e) {
			wlogger.error(e.getMessage());
		}catch(Error e1){
			wlogger.error(e1.getMessage());
		}
	}
	
	public static String conCatStr(Object str){
		String value="";
		String[] tempArr;
		try{
			if(null!=str){
				tempArr = (String[]) str;
			}else{
				return null;
			}
		}catch (Exception e) {
			tempArr = str.toString().replace("},", "}@@").split("@@");
		}
		for(int i=0;i<tempArr.length;i++){
//			JSONObject item = JSONObject.fromObject(tempArr[i]);
//			value = value + ";;;" + item.get("name")+";;"+item.get("type");
			value = value + ","+tempArr[i];
		}
		if(!"".equals(value)){
			value = value.substring(1);
		}
		value = "["+value+"]";
		return value;
	}
	
	public static String[] conCatAuth(Object str){
		String value1="",value2="";
		String[] tempArr;
		String[] retArr = {"",""};
		try{
			if(null!=str){
				tempArr = (String[]) str;
			}else{
				return retArr;
			}
		}catch (Exception e) {
			tempArr = str.toString().replace("},", "}@@").split("@@");
		}
		for(int i=0;i<tempArr.length;i++){
			JSONObject item = JSONObject.fromObject(tempArr[i]);
			if("user".equals(item.get("type"))){
				value1 = value1 + ";#" + item.get("id")+"#:"+item.get("auth");
			}else{
				value2 = value2 + ";#" + item.get("id")+"#:"+item.get("auth");
			}
		}
		if(!"".equals(value1)){//单用户权限
			retArr[0] = value1.substring(1);
		}
		if(!"".equals(value2)){//用户组权限
			retArr[1] = value2.substring(1);
		}
		return retArr; 
	}
	
	/*添加列表分页信息*/
	private static HashMap<String,Object> addPageParams(HashMap<String,Object> pMap){ 
		//
		if (null != pMap.get("count") || !"".equals(pMap.get("count"))){
			if (pMap.containsKey("page")){
				int page = Integer.parseInt(pMap.get("page").toString());
				int count = Integer.parseInt(pMap.get("count").toString());
				page = (page -1);
				pMap.put("page", page);
				pMap.put("count", count);
			}
		}
		return pMap;
	}
	
   //截取数字  
   public static String getNumbers(String content) {  
       Pattern pattern = Pattern.compile("\\d+");  
       Matcher matcher = pattern.matcher(content);  
       while (matcher.find()) {  
           return matcher.group(0);  
       }  
       return "";  
   }
   
}
