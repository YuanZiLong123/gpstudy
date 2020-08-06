package com.yzl.bean.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import com.yzl.pojo.User;

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
