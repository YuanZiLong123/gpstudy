package com.yzl.bean.definition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-06 15:09
 */
public class SingletonRegisterDemo2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(SingletonRegisterDemo2.class);

        ConfigurableListableBeanFactory configurableListableBeanFactory = annotationConfigApplicationContext.getBeanFactory();

        configurableListableBeanFactory.registerSingleton("beanInstantiationFactory",new BeanInstantiationFactory());



        annotationConfigApplicationContext.refresh();

        BeanInstantiationFactory beanInstantiationFactory =
                annotationConfigApplicationContext.getBean("beanInstantiationFactory",BeanInstantiationFactory.class);


        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/bean-instantitation.xml");


        BeanInstantiationFactory beanInstantiationFactory1 =
                classPathXmlApplicationContext.getBean("beanInstantiationFactory",BeanInstantiationFactory.class);
        System.out.println(beanInstantiationFactory==beanInstantiationFactory1);


        annotationConfigApplicationContext.close();

    }

}
