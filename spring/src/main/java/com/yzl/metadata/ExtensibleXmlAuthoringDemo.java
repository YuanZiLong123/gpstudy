package com.yzl.metadata;

import com.yzl.metadata.service.IUserService;
import com.yzl.pojo.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-17 10:20
 */
public class ExtensibleXmlAuthoringDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions("META-INF/spring/users-context.xml");


        User user = defaultListableBeanFactory.getBean(User.class);

        //User user = defaultListableBeanFactory.getBean("user", User.class);

        System.out.println(user);
    }
}
