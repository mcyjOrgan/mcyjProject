package common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringUtils {
    
    private static ApplicationContext applicationContext;
    
    public static void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringUtils.applicationContext = applicationContext;  
          
    }  
  
    public static ApplicationContext getApplicationContext(){
        return SpringUtils.applicationContext;  
    }  
      
    public static Object getBean(String name) throws BeansException {
        return SpringUtils.applicationContext.getBean(name);  
    }  
}
