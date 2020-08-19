package com.yzl.bean.lifecycle.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @author admin
 * @date 2020-08-12 14:11
 */
public class UserAware implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware
        , EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware
, MessageSourceAware,ApplicationContextAware, SmartInitializingSingleton {


    private String beanName;

    private BeanFactory beanFactory;

    private ClassLoader classLoader;

    private Environment environment;

    private StringValueResolver stringValueResolver;

    private ResourceLoader resourceLoader;

    private ApplicationEventPublisher applicationEventPublisher;

    private MessageSource messageSource;

    private ApplicationContext applicationContext;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName  = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @Override
    public String toString() {
        return "UserAware{" +
                "beanName='" + beanName + '\n' +
                ", beanFactory=" + beanFactory.getClass().getName() +'\n' +
                ", classLoader=" + classLoader.getClass().getName() +'\n' +
                ", environment=" + environment.getClass().getName() +'\n' +
                ", stringValueResolver=" + stringValueResolver.getClass().getName() +'\n' +
                ", resourceLoader=" + resourceLoader.getClass().getName() +'\n' +
                ", applicationEventPublisher=" + applicationEventPublisher.getClass().getName()+'\n' +
                ", messageSource=" + messageSource.getClass().getName()+'\n' +
                ", applicationContext=" + applicationContext.getClass().getName() +'\n' +
                '}';
    }

    @Override
    public void afterSingletonsInstantiated() {
        if (this.beanFactory instanceof DefaultListableBeanFactory){
            DefaultListableBeanFactory defaultListableBeanFactory
                    = DefaultListableBeanFactory.class.cast(this.beanFactory);
            String[] beanDefinitionNames  = defaultListableBeanFactory.getBeanDefinitionNames();
            for (String beanDefinitionName:beanDefinitionNames
                 ) {
                System.out.println(beanDefinitionName);
            }
        }
    }
}
