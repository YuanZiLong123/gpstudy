package com.yzl.bean.definition;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-06 14:16
 */
public class BeanInitializingObjectDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-application.xml");

       BeanInitializingObject beanInitializingObject =
               classPathXmlApplicationContext.getBean(BeanInitializingObject.class);

        System.out.println(beanInitializingObject.getName());

        classPathXmlApplicationContext.close();

    }

}
