package com.yzl.metadata;

import com.yzl.bean.lifecycle.entity.City;
import com.yzl.bean.lifecycle.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author admin
 * @date 2020-08-19 9:40
 */
@PropertySource("classpath:\\META-INF\\spring\\user.properties")
public class InjectDemo {

    @Bean
    public User createUser(@Value("${user.id}")Long userId, @Value("${user.name}")String userName,
                           @Value("${user.city}")City city, @Value("${user.workCities}")List<City> cityList){
        User user = new User();

        user.setId(userId);
        user.setName(userName);
        user.setCity(city);
        user.setWorkCities(cityList);
        return user;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(InjectDemo.class);

        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);

        System.out.println(user);


        applicationContext.close();
    }


}


