package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.SuperUser;
import com.yzl.bean.lifecycle.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-07 9:45
 */
public class MergedBeanDefinitionDemo {


    public static void main(String[] args) {
        /*DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String xmlLocations = "classpath:/META-INF/spring/bean-lifecycle.xml";
        int beanNumber = xmlBeanDefinitionReader.loadBeanDefinitions(xmlLocations);
         System.out.println("加载到的bean数量为"+beanNumber);

        User user = defaultListableBeanFactory.getBean("user", User.class);
        SuperUser superUser = defaultListableBeanFactory.getBean("superUser", SuperUser.class);

        System.out.println(user);
        System.out.println(superUser);*/


        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/bean-lifecycle.xml");

        User applicationContextUser = applicationContext.getBean("user", User.class);
        SuperUser applicationContextSuperUser = applicationContext.getBean("superUser", SuperUser.class);

        System.out.println(applicationContextUser);
        System.out.println(applicationContextSuperUser);
    }

}
