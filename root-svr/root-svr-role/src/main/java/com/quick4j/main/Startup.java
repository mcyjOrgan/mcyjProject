package com.quick4j.main;

import common.util.SpringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {
    private static final Log log = LogFactory.getLog(Startup.class);

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "classpath:spring/applicationContext.xml");
            context.start();
            SpringUtils.setApplicationContext(context);
        } catch (Exception e) {
            log.error("== DubboProvider context start error:", e);
        }
        synchronized (Startup.class) {
            while (true) {
                try {
                    Startup.class.wait();
                } catch (InterruptedException e) {
                    log.error("== synchronized error:", e);
                }
            }
        }
    }
}
