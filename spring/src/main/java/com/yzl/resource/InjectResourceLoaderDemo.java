package com.yzl.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @author admin
 * @date 2020-08-19 11:14
 */
public class InjectResourceLoaderDemo  implements ResourceLoaderAware {


    private ResourceLoader resourceLoader;

    @Autowired
    private ResourceLoader autowiredResourceLoader;


    @Autowired
    private AbstractApplicationContext applicationContext;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @PostConstruct
    public void init() {
        System.out.println("resourceLoader == autowiredResourceLoader : " + (resourceLoader == autowiredResourceLoader));
        System.out.println("resourceLoader == applicationContext : " + (resourceLoader == applicationContext));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(InjectResourceLoaderDemo.class);
        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.close();
    }

}
