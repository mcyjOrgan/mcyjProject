package com.eliteams.quick4j.web.listener;

import com.alibaba.fastjson.JSONObject;
import com.quick4j.service.*;
import com.sccs.api.client.DataListener;
import com.sccs.api.client.DataSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


/**
 * @author Tim.Shue
 *
 */
//@Controller
public class ApiDataListener extends DataListener {

    private final Logger logger = LoggerFactory.getLogger(ApiDataListener.class);

//    @Resource(name = "deviceAlarmApiService")
//    private DeviceAlarmApiServiceI deviceAlarmApiServiceI;
//
//    @Resource(name = "lampOpenStateApiService")
//    private LampOpenStateApiServiceI lampOpenStateApiServiceI;
//    @Resource(name = "lampElectricQuantityApiService")
//    private LampElectricQuantityApiServiceI lampElectricQuantityApiServiceI;
//
//    @Resource(name = "airQualityApiService")
//    private AirQualityApiServiceI airQualityApiServiceI;
//
//    @Resource(name = "chargeUseStateApiService")
//    private ChargeUseStateApiServiceI chargeUseStateApiServiceI;
//    @Resource(name = "chargeLogApiService")
//    private ChargeLogApiServiceI chargeLogApiServiceI;

    /**
     * 类初始化函数
     */
    public ApiDataListener(){
        //订阅开关(KM)的状态
//		DataSubscribe subscribe = new DataSubscribe("push-km","status","version");
//		this.addSubscribe(subscribe);
        //订阅电表数据
//		subscribe = new DataSubscribe("push-meter","data","version");
//		this.addSubscribe(subscribe);
        //订阅警报数据
        DataSubscribe subscribe = new DataSubscribe("push-alarm","alarm","1");
        this.addSubscribe(subscribe);
        //订阅终端(灯具)信息电量数据
        subscribe = new DataSubscribe("push-lcu","data","1");
        this.addSubscribe(subscribe);
        //订阅终端(灯具)单灯开关状态
        subscribe = new DataSubscribe("push-lcu","status","1");
        this.addSubscribe(subscribe);
        //订阅新能源充电桩,充电桩数据
//        subscribe = new DataSubscribe("push-charging","gun-status","version");
//        this.addSubscribe(subscribe);
//        subscribe = new DataSubscribe("push-charging","status","version");//开关状态
//        this.addSubscribe(subscribe);
        //订阅气象站设备状态
        subscribe = new DataSubscribe("push-sensor","status","1");//开关状态
        this.addSubscribe(subscribe);
    }

    @Override
    protected void pushData(int status, String msg, String cmd, String ctrl,	String version, JSONObject jsonData)  {
        // TODO 推送数据到第三方平台,服务器推送订阅的消息，可自行处理
//        String httpURL = "http://address:port/api/command";
        String data = jsonData.toJSONString();
        try{
            if("push-lcu".equalsIgnoreCase(cmd)){//忽略大小写
                logger.info("智慧灯杆推送数据-灯杆："+data);
                //如果是路灯，设置上报的数据
//                if ("status".equalsIgnoreCase(ctrl)){
//                    //开关状态
//                    if (lampOpenStateApiServiceI != null) {
//                        lampOpenStateApiServiceI.create(jsonData);
//                    }
//                }else if ("data".equalsIgnoreCase(ctrl)) {
//                    //电量上报
//                    if (lampElectricQuantityApiServiceI != null) {
//                        lampElectricQuantityApiServiceI.create(jsonData);
//                    }
//                }
            }else if("push-alarm".equalsIgnoreCase(cmd)){
                logger.info("智慧灯杆推送数据-告警："+data);
                //如果是警报数据，设置上报的数据
//                if ("alarm".equalsIgnoreCase(ctrl)) {
//                    if (deviceAlarmApiServiceI != null) {
//                        deviceAlarmApiServiceI.create(jsonData);
//                    }
//                }
            }else if("push-sensor".equalsIgnoreCase(cmd)){
                logger.info("智慧灯杆推送数据-环境监测："+data);
                //如果是环境监测，设置上报的数据
//                if ("data".equalsIgnoreCase(ctrl)) {
//                    //数据上报
//                    if (airQualityApiServiceI != null) {
//                        airQualityApiServiceI.create(jsonData);
//                    }
//                }else if ("status".equalsIgnoreCase(ctrl)) {
//                    if (airQualityApiServiceI != null) {
//                        airQualityApiServiceI.create(jsonData);
//                    }
//                }
            }else if("push-charging".equalsIgnoreCase(cmd)){
                logger.info("智慧灯杆推送数据-新能源充电桩："+data);
                //如果是新能源充电桩，设置上报的数据
//                if ("status".equalsIgnoreCase(ctrl)){
//                    //开关状态
//                    if (chargeUseStateApiServiceI != null) {
//                        chargeUseStateApiServiceI.create(jsonData);
//                    }
//                }else if ("gun-status".equalsIgnoreCase(ctrl)) {
//                    //充电数据上报
//                    if (chargeLogApiServiceI != null) {
//                        chargeLogApiServiceI.create(jsonData);
//                    }
//                }
            }else {logger.info("智慧灯杆推送数据-其他："+data);}

        //设置HTTP上报的客户端连接
//        HttpURLConnection pushUrl =null;
//        OutputStream writer = null;
//        ClosedHttpResponse responser=null;

//            URL url = new URL(httpURL);
//            //创建URL连接
//            pushUrl = (HttpURLConnection)url.openConnection();
//            pushUrl.setConnectTimeout(30000);
//            pushUrl.setReadTimeout(120000);
//            pushUrl.setRequestMethod("POST");
//            pushUrl.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
//            pushUrl.setRequestProperty("Accept", "*/*");
//            pushUrl.setRequestProperty("Accept-Language", "UTF-8");
//            pushUrl.setRequestProperty("Content-type", "text/html");
//            pushUrl.setRequestProperty("Charset", "utf-8");
//            //keep-Alive，有什么用呢，你不是在访问网站，你是在采集。嘿嘿。减轻别人的压力，也是减轻自己。
//            pushUrl.setRequestProperty("Connection", "close");
//            //不要用cache，用了也没有什么用，因为我们不会经常对一个链接频繁访问。（针对程序）
//            pushUrl.setUseCaches(false);
//            pushUrl.setConnectTimeout(6 * 1000);
//            pushUrl.setReadTimeout(60 * 1000);
//            pushUrl.setDoOutput(true);
//            pushUrl.setDoInput(true);
//            //提交JSON格式的用户登录请求
//            writer = pushUrl.getOutputStream();
//            writer.write(data.getBytes(), 0, data.getBytes().length);
//            writer.flush();
//            //创建返回对象
//            responser = new ClosedHttpResponse(pushUrl);

        }catch(Exception ex){
            logger.error("apiDataListener error:"+ex);
            ex.printStackTrace();
        }
//        finally{
//            //关闭输出流
//            if(writer!=null){
//                try{
//                    writer.close();
//                }catch(Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        }//end finully()
//        if(responser!=null){
//            responser.getContent();
//        }
    }// end pushData()

//    @RequestMapping(value = "testThis", method = RequestMethod.POST)
//    @ResponseBody
//    public void testThis(){
//        //测试是否可以使用service注解
//        GetAlarmUserAlarmSpotListVo getAlarmUserAlarmSpotListVo = new GetAlarmUserAlarmSpotListVo();
//        getAlarmUserAlarmSpotListVo.setEntSerno("5912310000001");
//        try{
//            alarmUserAlarmSpotService.getNewLastAlarmUserAlarm(getAlarmUserAlarmSpotListVo);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("OK");
//    }

}
