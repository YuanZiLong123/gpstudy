package com.yzl.metadata;

import com.yzl.metadata.entity.AnnotationPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 * @date 2020-08-14 16:38
 */
public class AnnotationApplicationContextDemo {

    @Bean
    public AnnotationPojo annotationPojo(){
        return new AnnotationPojo();
    }

    @Autowired
    private  AnnotationPojo annotationPojo;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(AnnotationApplicationContextDemo.class);

        annotationConfigApplicationContext.refresh();

        AnnotationApplicationContextDemo annotationApplicationContextDemo =
                annotationConfigApplicationContext.getBean(AnnotationApplicationContextDemo.class);

        System.out.println(annotationApplicationContextDemo.annotationPojo);

        //AnnotationPojo annotationPojo = annotationConfigApplicationContext.getBean("annotationPojo",AnnotationPojo.class);

        //System.out.println(annotationPojo);
    }

}


