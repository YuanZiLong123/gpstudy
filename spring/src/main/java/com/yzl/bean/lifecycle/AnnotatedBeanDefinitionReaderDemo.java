package com.yzl.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author admin
 * @date 2020-08-07 9:35
 */
public class AnnotatedBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory =
                new DefaultListableBeanFactory();

        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader =
                new AnnotatedBeanDefinitionReader(defaultListableBeanFactory);

        int registerBefore = defaultListableBeanFactory.getBeanDefinitionCount();


        annotatedBeanDefinitionReader.register(AnnotatedBeanDefinitionReaderDemo.class);

        defaultListableBeanFactory.getBean(AnnotatedBeanDefinitionReaderDemo.class);

        int registerAfter = defaultListableBeanFactory.getBeanDefinitionCount();

        System.out.println("加载到bean的数量为"+(registerAfter-registerBefore));


    }

}
