package com.yzl.aop;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Objects;

/**
 * @author admin
 * @date 2020-08-24 14:16
 */
@EnableAspectJAutoProxy
@Configuration
public class AopTestDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.yzl.aop");

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);



        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF\\spring\\aop.xml");

        annotationConfigApplicationContext.refresh();

        Person person = annotationConfigApplicationContext.getBean(Person.class);

        System.out.println(person.getClass());

        person.say();

        System.out.println("***************************************");

       /* Object animal = annotationConfigApplicationContext.getBean("animal");

        System.out.println(animal.getClass());

        if (animal instanceof IRunAbleInterface){
            IRunAbleInterface.class.cast(animal).run();
        }
*/
        IRunAbleInterface animal = (IRunAbleInterface) annotationConfigApplicationContext.getBean("animal");

        System.out.println(animal.getClass());
        IRunAbleInterface.class.cast(animal).run();

        annotationConfigApplicationContext.close();
    }
}
