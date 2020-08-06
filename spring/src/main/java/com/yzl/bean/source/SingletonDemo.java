package com.yzl.bean.source;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.yzl.pojo.SingletonObject;

/**
 * @author admin
 * @date 2020-08-06 9:19
 */
public class SingletonDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();


        annotationConfigApplicationContext.refresh();

        AutowireCapableBeanFactory autowireCapableBeanFactory=
                annotationConfigApplicationContext.getAutowireCapableBeanFactory();
        if (autowireCapableBeanFactory instanceof DefaultListableBeanFactory){
            DefaultListableBeanFactory beanFactory = DefaultListableBeanFactory.class.cast(autowireCapableBeanFactory) ;
            beanFactory.registerSingleton("singleton", SingletonObject.getInstance());
        }

        SingletonObject singletonObject = annotationConfigApplicationContext.getBean("singleton",SingletonObject.class);
        System.out.println(singletonObject);


        annotationConfigApplicationContext.close();


    }

}
