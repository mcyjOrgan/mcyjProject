package com.eliteams.quick4j.web.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sccs.api.client.ApiConnection;
import com.sccs.api.client.ClosedHttpResponse;
import common.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018/9/6.
 */
@Component
public class SccsHeartBeatJob {

    private final Logger logger = LoggerFactory.getLogger(SccsHeartBeatJob.class);

    public void checkHeart(){//通过获取控制柜的在线状态，判断心跳
        try {
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext servletContext = webApplicationContext.getServletContext();
            Object conn = servletContext.getAttribute("SCCS-API");
            if (conn != null) {
                logger.info("通过检查控制柜在线定义灯杆在线-定时任务开始");
                ApiConnection con = (ApiConnection)conn;

                JSONObject jsonData = new JSONObject();

                JSONObject node = new JSONObject();
                node.put("k", "enabled");
                node.put("o", "=");
                node.put("v", true);
                JSONArray wheres = new JSONArray();
                wheres.add(node);
                jsonData.put("wheres", wheres);
                node = new JSONObject();
                node.put("k", "name");
                node.put("v", "ASC");
                JSONArray orders = new JSONArray();
                orders.add(node);
                jsonData.put("orders", orders);
                logger.info("++++++++++:" + jsonData.toJSONString());
                ClosedHttpResponse responser = con.send("project","list", "1", jsonData.toJSONString());
//                ClosedHttpResponse responser = con.send("data-rtu","get", "1", jsonData.toJSONString());
                logger.info("++++++++++:" + responser.getStatusCode() + "," + responser.getMessage() + "," + responser.getContent());
                if (responser.getStatusCode() == 200) {
                    logger.info("控制柜状态信息："+responser.getContent());
                    JSONArray jsonArray = JSONArray.parseArray(responser.getContent());
                    doPost(jsonArray);
                }
            }
            logger.info("通过检查控制柜在线定义灯杆在线-定时任务结束");
        }catch (Exception e){
            logger.error("sccsHeart error:"+e);
        }
    }

    public JSONObject doPost(JSONArray jsonArray) throws Exception{
        PropertiesUtil propertiesUtil = PropertiesUtil.getInstance("requestAddr");
        String SCCS_HEART_URL = propertiesUtil.get("sccs.heart.url");

        String json_send_sms = jsonArray.toJSONString();
        URL sendUrl = new URL(SCCS_HEART_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) sendUrl.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        OutputStream out = httpURLConnection.getOutputStream();
        out.write(json_send_sms.getBytes("UTF-8"));
        System.out.println("sendLampOnStatus send msg:\t" + json_send_sms);
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            logger.info("sendLampOnStatus recv msg:\t" + resultBuffer.toString());
            return JSONObject.parseObject(resultBuffer.toString());
        } catch (Exception e) {
            throw e;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            httpURLConnection.disconnect();
        }
    }
}
