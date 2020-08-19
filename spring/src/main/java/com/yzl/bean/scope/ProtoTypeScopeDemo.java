package com.yzl.bean.scope;

import com.yzl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author admin
 * @date 2020-08-06 10:22
 */
public class ProtoTypeScopeDemo {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User protoTypeUser(){

        return User.createUser();
    }

    @Autowired
    @Qualifier("protoTypeUser")
    public User user;
    @Autowired
    @Qualifier("protoTypeUser")
    public User user1;
    @Autowired
    @Qualifier("protoTypeUser")
    public User user2;
    @Autowired
    @Qualifier("protoTypeUser")
    public User user3;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(ProtoTypeScopeDemo.class);

        annotationConfigApplicationContext.refresh();

        ProtoTypeScopeDemo protoTypeScopeDemo = annotationConfigApplicationContext.getBean(ProtoTypeScopeDemo.class);

        System.out.println(protoTypeScopeDemo.user);
        System.out.println(protoTypeScopeDemo.user1);
        System.out.println(protoTypeScopeDemo.user2);
        System.out.println(protoTypeScopeDemo.user3);

        annotationConfigApplicationContext.close();

    }

}
