package com.yzl.metadata;

import com.yzl.metadata.entity.AnnotationPojo;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author admin
 * @date 2020-08-14 13:40
 */
public class AnnotationDemo {


    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory =
                new DefaultListableBeanFactory();

        defaultListableBeanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader =
                new AnnotatedBeanDefinitionReader(defaultListableBeanFactory);



        annotatedBeanDefinitionReader.register(AnnotationPojo.class);

       AnnotationPojo annotationPojo = defaultListableBeanFactory.getBean("annotationPojo",AnnotationPojo.class);

        System.out.println(annotationPojo);
    }

}
