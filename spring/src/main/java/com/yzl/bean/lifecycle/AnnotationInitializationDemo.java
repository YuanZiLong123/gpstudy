package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.UserHolder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020-08-12 11:41
 */
public class AnnotationInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("com.yzl.bean.lifecycle.entity");
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);


        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF\\spring\\bean-instantiation.xml");


       UserHolder userHolder = annotationConfigApplicationContext.getBean(UserHolder.class);

        System.out.println(userHolder);
    }

}
