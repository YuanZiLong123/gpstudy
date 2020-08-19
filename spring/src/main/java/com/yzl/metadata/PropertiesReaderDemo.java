package com.yzl.metadata;

import com.yzl.metadata.entity.PropertiesPojo;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author admin
 * @date 2020-08-14 9:25
 */
public class PropertiesReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory =
                new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader
                = new PropertiesBeanDefinitionReader(defaultListableBeanFactory);

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource =  resourceLoader.getResource("META-INF/spring/bean-metadata.properties");

        EncodedResource encodedResource = new EncodedResource(resource,"utf-8");

        propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);

        PropertiesPojo propertiesPojo = defaultListableBeanFactory.getBean("propertiesPojo", PropertiesPojo.class);

        System.out.println(propertiesPojo);
    }

}



