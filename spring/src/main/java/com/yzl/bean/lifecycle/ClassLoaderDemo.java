package com.yzl.bean.lifecycle;

import com.yzl.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-10 15:20
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/bean-lifecycle.xml");

        User user = classPathXmlApplicationContext.getBean("user", User.class);


    }

}
