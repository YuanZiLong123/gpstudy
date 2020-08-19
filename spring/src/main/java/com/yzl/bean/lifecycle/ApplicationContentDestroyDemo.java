package com.yzl.bean.lifecycle;

import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-12 15:02
 */
public class ApplicationContentDestroyDemo {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF\\spring\\bean-application-instantiation.xml");
        classPathXmlApplicationContext.getBeanFactory().addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        //classPathXmlApplicationContext.refresh();

       // classPathXmlApplicationContext.getBean(UserHolder.class);

        //Thread.sleep(5000);

        classPathXmlApplicationContext.close();
    }

}
