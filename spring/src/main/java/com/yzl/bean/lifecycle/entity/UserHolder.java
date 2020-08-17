package com.yzl.bean.lifecycle.entity;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author admin
 * @date 2020-08-11 9:53
 */
@Data
public class UserHolder  implements InitializingBean, DisposableBean,SmartInitializingSingleton {

    private final  User user;


    private Integer version;


    private String describe;



    public UserHolder(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", version=" + version +
                ", describe='" + describe + '\'' +
                '}';
    }


    @PostConstruct
    public void postConstruct(){

        this.version =4;
        this.describe = "版本升级 3->4";

        System.out.println("postConstruct()"+this.describe);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.version =5;
        this.describe = "版本升级 4->5";

        System.out.println("afterPropertiesSet()"+this.describe);
    }


    /**
     * 自定义初始化
     */
    public void init(){
        this.version =6;
        this.describe = "版本升级 5->6";

        System.out.println("init() 自定义"+this.describe);
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy()销毁");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()销毁");
    }


    public void myDestroy(){
        System.out.println("myDestroy() 自定义销毁");
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.version =7;
        this.describe = "版本升级 6->7";

        System.out.println("init() 自定义"+this.describe);
    }
}



