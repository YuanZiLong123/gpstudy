package com.yzl.resource;

import com.yzl.resource.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * @author admin
 * @date 2020-08-19 10:50
 */
public class InjectDemo {

    @Value("classpath:/META-INF\\spring\\user.properties")
    private Resource resource;


    @Value("classpath:/META-INF\\spring\\*.properties")
    private Resource[] resources;

    @Value("${user.dir}")
    private String systemPath;


    @PostConstruct
    public void init(){
        System.out.println("resource is "+ ResourceUtils.getContent(resource));


        System.out.println("************************************");

        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);

        System.out.println("************************************");

        System.out.println("systemPath is "+systemPath);

    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(InjectDemo.class);

        context.refresh();



        context.close();
    }
}
