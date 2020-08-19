package com.yzl.bean.definition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020-08-06 15:09
 */
public class SingletonRegisterDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(SingletonRegisterDemo.class);

        ConfigurableListableBeanFactory configurableListableBeanFactory = annotationConfigApplicationContext.getBeanFactory();

        configurableListableBeanFactory.registerSingleton("beanInstantiationFactory",new BeanInstantiationFactory());

        String xmlPath = "classpath:/META-INF/spring/bean-instantitation.xml";

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);

        xmlBeanDefinitionReader.loadBeanDefinitions(xmlPath);


        annotationConfigApplicationContext.refresh();

        BeanInstantiationFactory beanInstantiationFactory =
                annotationConfigApplicationContext.getBean("beanInstantiationFactory",BeanInstantiationFactory.class);


        BeanInstantiationFactory beanInstantiationFactory1 =
                annotationConfigApplicationContext.getBean("beanInstantiationFactory", BeanInstantiationFactory.class);


        System.out.println(beanInstantiationFactory==beanInstantiationFactory1);


        annotationConfigApplicationContext.close();

    }

}
