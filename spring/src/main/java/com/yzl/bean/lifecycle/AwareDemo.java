package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.UserAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-12 14:12
 */
public class AwareDemo {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF\\spring\\bean-aware.xml");



        UserAware userAware = classPathXmlApplicationContext.getBean(UserAware.class);



        //System.out.println(userAware);

        //classPathXmlApplicationContext.close();
    }

}
