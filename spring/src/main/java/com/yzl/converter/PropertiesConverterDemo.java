package com.yzl.converter;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @date 2020-08-25 10:35
 */
public class PropertiesConverterDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF\\spring\\converter.xml");

        Person person = applicationContext.getBean(Person.class);

        System.out.println(person);
    }

}
