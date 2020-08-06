package com.yzl.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import com.yzl.pojo.User;

/**
 * @author admin
 * @date 2020-08-06 10:13
 */
public class SingletonScopeDemo {

    @Bean
    public User user(){
        return User.createUser();
    }

    @Autowired
    @Qualifier("user")
    private User user;

    @Autowired
    @Qualifier("user")
    private User user1;

    @Autowired
    @Qualifier("user")
    private User user2;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(SingletonScopeDemo.class);

        annotationConfigApplicationContext.refresh();

        SingletonScopeDemo singletonScopeDemo = annotationConfigApplicationContext.getBean(SingletonScopeDemo.class);

        System.out.println(singletonScopeDemo.user);
        System.out.println(singletonScopeDemo.user1);
        System.out.println(singletonScopeDemo.user2);

        annotationConfigApplicationContext.close();
    }
}
