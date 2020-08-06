package com.yzl.bean.source;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.yzl.pojo.User;

/**
 * @author admin
 * @date 2020-08-06 9:12
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.registerBeanDefinition("user",getBeanDefinition());

        annotationConfigApplicationContext.refresh();

        User user = annotationConfigApplicationContext.getBean("user",User.class);

        System.out.println(user);

        annotationConfigApplicationContext.close();
    }



    public static BeanDefinition getBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addConstructorArgValue(1)
                .addConstructorArgValue("张三")
                .addConstructorArgValue(18);

        return beanDefinitionBuilder.getBeanDefinition();

    }
}
