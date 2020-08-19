package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author admin
 * @date 2020-08-07 9:10
 */
public class PropertiesBeanDefinitionReaderDemo {


    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader =
                new PropertiesBeanDefinitionReader(defaultListableBeanFactory);

        String propertiesLocation = "/META-INF/spring/user.properties";

        Resource resource = new ClassPathResource(propertiesLocation);

        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");

        int beanNumber = propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);

        System.out.println("加载到的bean数量为"+beanNumber);


        User user = defaultListableBeanFactory.getBean(User.class);

        System.out.println(user);

    }
}
