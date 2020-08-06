package com.yzl.bean.source;

import com.sun.javafx.runtime.SystemProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @author admin
 * @date 2020-08-06 9:57
 */
@Configuration
@PropertySource(value = "META-INF/spring/config.properties",encoding = "UTF-8")
public class ExternalConfigDependencyDemo{

    private SystemProperties systemProperties;

    @Value("${user.id:-1}")
    private Long id;

    @Value("${usr.name:zhangsan}")
    private String name;

    @Value("${user.resource:classpath:/default.properties}")
    private Resource resource;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(ExternalConfigDependencyDemo.class);

        annotationConfigApplicationContext.refresh();

        ExternalConfigDependencyDemo externalConfigDependencyDemo =
                annotationConfigApplicationContext.getBean(ExternalConfigDependencyDemo.class);

        System.out.println(externalConfigDependencyDemo.id);
        System.out.println(externalConfigDependencyDemo.name);
        System.out.println(externalConfigDependencyDemo.resource);

        annotationConfigApplicationContext.close();
    }
}
