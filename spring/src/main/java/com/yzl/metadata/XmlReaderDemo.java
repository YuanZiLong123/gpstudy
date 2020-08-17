package com.yzl.metadata;

import com.yzl.metadata.entity.XmlPojo;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author admin
 * @date 2020-08-14 9:22
 */
public class XmlReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory =
                new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions("META-INF/spring/bean-metadata.xml");


        XmlPojo xmlPojo = defaultListableBeanFactory.getBean("xmlPojo", XmlPojo.class);

        System.out.println(xmlPojo);

    }

}
