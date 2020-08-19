package com.yzl.injection;

import com.yzl.pojo.User;
import com.yzl.pojo.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author admin
 * @date 2020-08-04 10:35
 */
public class XmlSpringStartUpDemo {


    public static void main(String[] args) {
       /* ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-application.xml");
        User user = classPathXmlApplicationContext.getBean("user", User.class);

        UserResponsory userResponsory = classPathXmlApplicationContext.getBean(UserResponsory.class);



        System.out.println(user);


        System.out.println(userResponsory);*/

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.yzl");
        annotationConfigApplicationContext.register(XmlSpringStartUpDemo.class);


       /* String xmlPath = "classpath:/META-INF/spring/spring-application.xml";


        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);

        xmlBeanDefinitionReader.loadBeanDefinitions(xmlPath);*/


        annotationConfigApplicationContext.refresh();

        //User annotationUser = annotationConfigApplicationContext.getBean(User.class);

       // System.out.println(annotationUser);


        UserRepository annotationUserRepository = annotationConfigApplicationContext.getBean(UserRepository.class);


        System.out.println(annotationUserRepository);

        annotationConfigApplicationContext.close();

    }



    @Bean
    @Primary
    public User createUser(){
        User user = new User();

        user.setId(2L);
        user.setName("李");
        user.setAge(20);
        return user;
    }



   /* @Bean
    public UserRepository createUserRepository(){
        return new UserRepository();
    }*/
}
