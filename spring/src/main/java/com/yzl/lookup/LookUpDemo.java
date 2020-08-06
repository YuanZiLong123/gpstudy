package com.yzl.lookup;

import com.yzl.pojo.User;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-06 13:48
 */
public class LookUpDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-application.xml");

        classPathXmlApplicationContext.getBean("user");

        classPathXmlApplicationContext.getBean(User.class);

        classPathXmlApplicationContext.getBean("user",User.class);
    }
}
