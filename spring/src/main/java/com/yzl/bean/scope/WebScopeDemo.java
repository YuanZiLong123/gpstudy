package com.yzl.bean.scope;

import com.yzl.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author admin
 * @date 2020-08-06 11:01
 */
public class WebScopeDemo {

    @Bean
    @RequestScope
    public User requestUser(){
        return User.createUser();
    }

    @Bean
    @SessionScope
    public User sessionUser(){
        return User.createUser();
    }

    @Bean
    @ApplicationScope
    public User applicationUser(){
        return User.createUser();
    }

}
