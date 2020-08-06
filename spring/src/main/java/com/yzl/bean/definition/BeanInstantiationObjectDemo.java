package com.yzl.bean.definition;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * bean的实例demo
 * @author admin
 * @date 2020-08-06 14:36
 */
public class BeanInstantiationObjectDemo {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/bean-instantitation.xml");

        classPathXmlApplicationContext.getBean(BeanInstantiationObjectByStaticMethod.class);



        classPathXmlApplicationContext.getBean(BeanInstantiationObjectByFactory.class);


        classPathXmlApplicationContext.getBean(BeanInstantiationObjectByInstance.class);
    }
}
