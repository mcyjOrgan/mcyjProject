package com.eliteams.quick4j.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sccs.api.client.ApiConnection;
import com.sccs.api.client.ClosedHttpResponse;
import com.sccs.api.client.DataSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Application Lifecycle Listener implementation class ApiServletListener
 *
 */
@WebListener
public class ApiServletListener implements ServletContextListener {

    private final Logger logger = LoggerFactory.getLogger(ApiServletListener.class);
    /**
     * Default constructor.
     */
    public ApiServletListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  {
        // TODO Auto-generated method stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  {

        // TODO引用程序启动的时候启动WebSocket监听
        try {
            ServletContext context = event.getServletContext();
            //获取API参数
            String address = context.getInitParameter("ApiAddress");
            String token = context.getInitParameter("ApiToken");
            String key = context.getInitParameter("ApiKey");
            //获取SCCS API接口连接对象
            ApiConnection conn= new ApiConnection();

            conn.open(address, key, token, "zh_CN");

            //发送获取项目列表的命令--这段主动查询数据，看需要使用
            // project:list[version:1] > data: {"wheres":[{"k":"enabled","o":"=","v":true}],"orders":[{"k":"name","v":"ASC"}]}

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
            System.out.println("++++++++++:"+jsonData.toJSONString());
            ClosedHttpResponse responser = conn.send("project","list", "1", jsonData.toJSONString());
            System.out.println("++++++++++:" +responser.getStatusCode() + "," +responser.getMessage()+","+ responser.getContent());

            String data = " {\"wheres\":[{\"k\":\"enabled\",\"o\":\"=\",\"v\":true}],\"orders\":[{\"k\":\"name\",\"v\":\"ASC\"}]}";
            System.out.println("++++++++++:"+ data);
            responser = conn.send("project","list", "1",data);
            System.out.println("++++++++++:"+responser.getStatusCode() + "," +responser.getMessage()+","+ responser.getContent());


            //添加主动上行数据的监听和第三方数据推送接口
//            ApiDataListener dataPusher = new ApiDataListener();
            //添加气象站环境监测数据上行监听
//            DataSubscribe sensorData = new DataSubscribe("push-sensor","data","1");
//            dataPusher.addSubscribe(sensorData);

            //添加数据监听对象到API接口对象中
//            conn.addDataListener(dataPusher);

            //保存APi-Connection到应用程序上下文
            context.setAttribute("SCCS-API", conn);

        } catch (Exception e) {
            logger.error("apiServletListener error:"+e);
            e.printStackTrace();
        }
    }
}
