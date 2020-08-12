package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.SuperUser;
import com.yzl.bean.lifecycle.entity.User;
import com.yzl.bean.lifecycle.entity.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author admin
 * @date 2020-08-11 9:19
 */
public class InitalizationAwareBeanPostProcessorDemo {


    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        defaultListableBeanFactory.addBeanPostProcessor(new MyInitializationAwareBeanPostProcessor());

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String location =  "classpath:/META-INF\\spring\\bean-instantiation.xml";

        xmlBeanDefinitionReader.loadBeanDefinitions(location);

       // User userByType = defaultListableBeanFactory.getBean(User.class);
        UserHolder userHolder  = defaultListableBeanFactory.getBean("userHolder", UserHolder.class);

        User user = defaultListableBeanFactory.getBean("user", User.class);

        SuperUser superUser  = defaultListableBeanFactory.getBean("superUser", SuperUser.class);


        System.out.println(user);
        System.out.println(superUser);
        System.out.println(userHolder);

    }






}
