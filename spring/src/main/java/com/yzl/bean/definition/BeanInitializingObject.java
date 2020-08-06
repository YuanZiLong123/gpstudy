package com.yzl.bean.definition;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * bean的初始化和销毁
 * @author admin
 * @date 2020-08-06 14:12
 */
public class BeanInitializingObject implements InitializingBean, DisposableBean {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 自定义bean初始化
     */
    @PostConstruct
    public void init(){
        this.name = "1";
        System.out.println("基于@PostConstruct bean初始化");
    }


    /**
     * 自定义的初始化与销毁 必须基于xml
     */
    public void initByMyself(){
        this.name = "3";
        System.out.println("自定义的初始化");
    }


    public void destroyByMyself(){
        System.out.println("自定义的销毁");
    }

    /**
     * 自定义bean销毁
     */
    @PreDestroy
    public void preDestroy(){
        System.out.println("基于@PreDestroy bean销毁");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("实现 Initializing  Bean销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "2";
        System.out.println("实现 Disposable   Bean初始化");
    }
}
