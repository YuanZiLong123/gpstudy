package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.SuperUser;
import com.yzl.bean.lifecycle.entity.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author admin
 * @date 2020-08-07 9:10
 */
public class XmlBeanDefinitionReaderDemo {


    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String xmlLocations = "classpath:/META-INF/spring/bean-lifecycle.xml";
        int beanNumber = xmlBeanDefinitionReader.loadBeanDefinitions(xmlLocations);


        System.out.println("加载到的bean数量为"+beanNumber);

        User user = defaultListableBeanFactory.getBean("user", User.class);
        SuperUser superUser = defaultListableBeanFactory.getBean("superUser", SuperUser.class);

        System.out.println(user);
        System.out.println(superUser);


    }
}
