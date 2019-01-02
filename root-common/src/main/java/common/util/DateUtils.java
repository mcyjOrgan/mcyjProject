package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

	public static void main(String[] args) {


	}
	
	public static final String FORMATPATTERN_DATE = "yyyy-MM-dd";  
    
	public static final String FORMATPATTERN_SHORT_DATE = "yyyyMMdd";  
    
	public static final String FORMATPATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    
    private static SimpleDateFormat sdf_datetime = new SimpleDateFormat(FORMATPATTERN_DATETIME);
    private static SimpleDateFormat sdf_date = new SimpleDateFormat(FORMATPATTERN_DATE);
    
    /** 锁对象 */
    private static final Object lockObj = new Object();

    /** 存放不同的日期模板格式的sdf的Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     * 
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    System.out.println("put new sdf of pattern " + pattern + " to map");

                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {

                        @Override
                        protected SimpleDateFormat initialValue() {
                            System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * 是用ThreadLocal<SimpleDateFormat>来获取SimpleDateFormat,这样每个线程只会有一个SimpleDateFormat
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }
      
      
    /** 
     * 获取当前日期 
     * @return String
     */  
    public static String getCurrentDate(){  
        return sdf_date.format(new Date());  
    }

    /**
     * 根据参数获取当前时间格式
     * @return String
     */
    public static String getCurrentDateByParam(String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    /**
     * 获取当前日期
     * @return Date
     */
    public static Date getTodayDateTime() throws ParseException{
        return sdf_date.parse(sdf_date.format(new Date()));
    }

    /**
     * 获取当前日期及时间
     * @return Date
     */
    public static Date getTodayDate() throws ParseException{
        return sdf_datetime.parse(sdf_datetime.format(new Date()));
    }

    /** 
     * 获取当前日期及时间
     * @return 
     */  
    public static String getCurrentDateTime(){  
    	return sdf_datetime.format(new Date());  
    }  
      
    /** 
     * 获取指定毫秒数之前的日期 
     * @param timeDiff 
     * @return 
     */  
    public static String getDesignatedDate(long timeDiff){  
        long nowTime = System.currentTimeMillis();  
        long designTime = nowTime - timeDiff;         
        return sdf_date.format(designTime);  
    }  
      
    /** 
     *  
     * 获取前几天的日期 
     */  
    public static String getPrefixDate(String count){  
        Calendar cal = Calendar.getInstance();  
        int day = 0-Integer.parseInt(count);  
        cal.add(Calendar.DATE,day);   // int amount   代表天数  
        Date datNew = cal.getTime();   
        return sdf_date.format(datNew);  
    } 
    
    /** 
     * 日期转换成字符串 
     * @param date 
     * @return 
     */  
    public static String dateToString(Date date){  
    	if(date == null){
    		return null;
    	}
        return sdf_date.format(date);  
    }
    
    /** 
     * 日期转换成字符串 
     * @param date 
     * @return 
     */  
    public static String dateToTimeString(Date date){  
    	if(date == null){
    		return null;
    	}
    	return sdf_datetime.format(date);  
    } 
    
    /** 
     * 字符串转换日期 
     * @param str 
     * @return 
     */  
    public static Date stringToDate(String str){  
        //str =  " 2008-07-10" 格式  
        if(!str.equals("")&&str!=null){  
            try {  
                return sdf_date.parse(str);  
            } catch (ParseException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
    
    /** 
     * 字符串转换日期 
     * @param str 
     * @return 
     */  
    public static Date timeStringToDate(String str){  
    	//str =  " 2008-07-10 10:10:10" 格式  
    	if(str!=null&&!"".equals(str.trim())){
                try {
                    return sdf_datetime.parse(str);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
    	return null;  
    }  
      
    //java中怎样计算两个时间如：“21:57”和“08:20”相差的分钟数、小时数 java计算两个时间差小时 分钟 秒 .  
    public void timeSubtract(){  
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        Date begin = null;   
        Date end = null;   
        try {   
        begin = dfs.parse("2004-01-02 11:30:24");   
        end = dfs.parse("2004-03-26 13:31:40");   
        } catch (ParseException e) {   
        e.printStackTrace();   
        }   
  
        long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒   
  
        long day1 = between / (24 * 3600);   
        long hour1 = between % (24 * 3600) / 3600;   
        long minute1 = between % 3600 / 60;   
        long second1 = between % 60;   
        System.out.println("" + day1 + "天" + hour1 + "小时" + minute1 + "分"   
        + second1 + "秒");   
    }  
    
    
    /**
	 * 返回指定格式的时间字符串
	 * 
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String getDateTime(String format) {
		String strDateTime = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		strDateTime = sdf.format(new Date());
		return strDateTime;
	}

	
	/**
	 * 得到小时
	 * @param date
	 * @param addHour
	 * @return
	 */
	public static int getHour(Date date,int addHour){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, addHour);
		
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 得到添加天数后的时间
	 * @param date
	 * @param addHour
	 * @return
	 */
	public static Date getDateAndDay(Date date,int addDay){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, addDay);
		
		return c.getTime();
	}
	
	
	/**
	 * 得到添加小时后的时间
	 * @param date
	 * @param addHour
	 * @return
	 */
	public static Date getDateAndHour(Date date,int addHour){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, addHour);
		
		return c.getTime();
	}
	
	
	/**
	 * 得到添加分钟后的时间
	 * @param date
	 * @param addHour
	 * @return
	 */
	public static Date getDateAndMin(Date date,int addMin){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, addMin);
		
		return c.getTime();
	}
	
	
	
	/**
	 * 通过日期字符串得到时间
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date getDateFromStr(String dateStr,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 返回指定格式的时间字符串
	 * 
	 * @param date
	 *            时间
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String getDateTime(Date date, String format) {
		String strDateTime = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		strDateTime = sdf.format(date);
		return strDateTime;
	}
	
	
	/**
     * 获取当前时间
     * 
     * @param args
     */
    public static String getNowTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    /**
     * 判断当天是否为本月第一天
     * 
     * @return
     */
    public static boolean isFirstDayOfMonth(Date date) {
        boolean flag = false;        
        Calendar calendar = Calendar.getInstance();
        if (null != date){
            calendar.setTime(date);
        }
        
        int today = calendar.get(Calendar.DAY_OF_MONTH);       
        
        if (1 == today) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取当月的 天数
     *
     * @return int
     */
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据年 月 获取对应的月份 天数
     *
     * @return int
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当前月份最后一天
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate(Date date) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        if (null != date){
            calendar.setTime(date);
        }else{
            calendar.setTime(new Date());
        }
        
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 
     * 描述:获取下一个月的第一天.
     * 
     * @return
     */
    public static String getPerFirstDayOfMonth() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 
     * 描述:获取上个月的最后一天.
     * 
     * @return
     */
    public static String getLastMaxMonthDate() {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 获取上一个月
     * 
     * @return
     */
    public static String getLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null){
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    /**
     * 
     * 描述:获取下一个月.
     * 
     * @return
     */
    public static String getNexMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null){
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }

    // 是否是最后一天
    public static boolean isLastDayOfMonth(Date date) {
        boolean flag = false;
        if (getNowTime().equals(getMaxMonthDate(date))) { 
            flag = true;
        }
        return flag;
    }
    
    /**
     * 获取任意时间的下一个月
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getNexMonth(String date) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        int year = Integer.parseInt(date.substring(0, 4));
        String monthsString = date.substring(4, 6);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
    
    /**
     * 获取任意时间的上一个月
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getLastMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(4, 6);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month-2,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
     //
    /**
     * 获取任意时间的月的最后一天
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getMaxMonthDate(String repeatDate) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        try {
            if(null != repeatDate && !"".equals(repeatDate)){
                calendar.setTime(dft.parse(repeatDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }
    
    /**
     * 获取任意时间的月第一天
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getMinMonthDate(String repeatDate){
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        try {
            if(null != repeatDate && !"".equals(repeatDate)){
                calendar.setTime(dft.parse(repeatDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
       return dft.format(calendar.getTime());        
    }
    /**
     * 不论是当前时间，还是历史时间  皆是时间点的前天
     * repeatDate  任意时间
     */
    public static String getModify2DaysAgo(String repeatDate) {
        Calendar cal = Calendar.getInstance();
        String daysAgo = "";
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        if (repeatDate == null || "".equals(repeatDate)) {
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 2);

        } else {
            int year = Integer.parseInt(repeatDate.substring(0, 4));
            String monthsString = repeatDate.substring(4, 6);
            int month;
            if ("0".equals(monthsString.substring(0, 1))) {
                month = Integer.parseInt(monthsString.substring(1, 2));
            } else {
                month = Integer.parseInt(monthsString.substring(0, 2));
            }
            String dateString = repeatDate.substring(6, 8);
            int date;
            if ("0".equals(dateString.subSequence(0, 1))) {
                date = Integer.parseInt(dateString.substring(1, 2));
            } else {
                date = Integer.parseInt(dateString.substring(0, 2));
            }
            cal.set(year, month-1, date - 1);
            System.out.println(dft.format(cal.getTime()));
        }
        daysAgo = dft.format(cal.getTime());
        return daysAgo;
    }
    
    /**
     * 不论是当前时间，还是历史时间  皆是时间点的T-N天
    * repeatDate 任意时间    param 数字 可以表示前几天
     */
    public static String getModifyNumDaysAgo(String repeatDate,int param) {
        Calendar cal = Calendar.getInstance();
        String daysAgo = "";
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        if (repeatDate == null || "".equals(repeatDate)) {
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) - param);

        } else {
            int year = Integer.parseInt(repeatDate.substring(0, 4));
            String monthsString = repeatDate.substring(4, 6);
            int month;
            if ("0".equals(monthsString.substring(0, 1))) {
                month = Integer.parseInt(monthsString.substring(1, 2));
            } else {
                month = Integer.parseInt(monthsString.substring(0, 2));
            }
            String dateString = repeatDate.substring(6, 8);
            int date;
            if ("0".equals(dateString.subSequence(0, 1))) {
                date = Integer.parseInt(dateString.substring(1, 2));
            } else {
                date = Integer.parseInt(dateString.substring(0, 2));
            }
            cal.set(year, month-1, date - param+1);
            System.out.println(dft.format(cal.getTime()));
        }
        daysAgo = dft.format(cal.getTime());
        return daysAgo;
    }
//获取当前毫秒时间戳
    public static String nowDate2Millisecond(){
        Date newDate = new Date();
        SimpleDateFormat simpleDF = new SimpleDateFormat("yyyyMMddHHmmssFFF");
        return simpleDF.format(newDate);
    }
//获取当前秒时间戳
    public static String nowDate2second(){
        Date newDate = new Date();
        SimpleDateFormat simpleDF = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDF.format(newDate);
    }

//    / *
//                 * @param dateStr
//	 *            :字符串日期
//	 * @param format
//	 *            :格式("yyyyMMdd")
//	 * @return date
//	 * @throws Exception
//	 */
    public static Date StrToDate(String dateStr, String format)throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = sdf.parse(dateStr);
        return date;
    }



    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 将时间字符串格式化
     * @param time
     * @return
     */
    public static String dateStringFormat(String time) {
//        String time = subStr("20100421134933");
        String YY = time.substring(0,4);
        String MM = time.substring(4,6);
        String dd = time.substring(6,8);
        String hh = time.substring(8,10);
        String mm = time.substring(10,12);
        String ss = time.substring(12,time.length());
        String result = YY+"-"+MM+"-"+dd+" "+hh+":"+mm+":"+ss;
        return result;
    }

}
