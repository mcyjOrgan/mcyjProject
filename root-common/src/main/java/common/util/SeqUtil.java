package common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class SeqUtil {
	/*
	 * 本类用于获取mysql全局自增主键，格式为  时间戳(yyMMddHHmm) + 5 位自增，自增范围根据配置获取
	 */
	
	private static DateFormat df = new SimpleDateFormat("yyMMddHHmmss");//主键时间戳
	private static final int MAX_SEQ = 9999; // 计数位最大值
	private static final int RESET_SEQ = 1; //计数位重置初始值
	private static AtomicInteger seq = new AtomicInteger(RESET_SEQ); //计数器
	private static final String SERVER_NODE = "01";
//	private static final String SERVER_NODE = Config.getValueByKey("SERVER_NODE");
	/**
	 * 获取主键
	 * 功能说明:   
	 * author：Suyz 
	 * 创建时间：2015-5-27
	 * @return
	 */
	public static String getSeqId(){
		seq.compareAndSet(MAX_SEQ, RESET_SEQ); //判断是否进行重置
		return df.format(new Date()) + SERVER_NODE + String.format("%04d", seq.incrementAndGet());
	}
}
