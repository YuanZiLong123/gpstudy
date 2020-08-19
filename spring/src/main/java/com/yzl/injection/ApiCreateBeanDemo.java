package com.yzl.injection;

import com.yzl.pojo.User;
import com.yzl.pojo.UserReference;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author admin
 * @date 2020-07-31 9:23
 */
public class ApiCreateBeanDemo {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition constructorBeanDefinition = createBeanDefinitionByConstructor();
        BeanDefinition setterBeanDefinition = createBeanDefinitionBySetter();


        BeanDefinition constructorReferenceBeanDefinition = createBeanDefinitionByConstructorReference();
        BeanDefinition setterReferenceBeanDefinition = createBeanDefinitionBySetterReference();



        beanFactory.registerBeanDefinition("constructorUser", constructorBeanDefinition);
        beanFactory.registerBeanDefinition("setterUser", setterBeanDefinition);
        beanFactory.registerBeanDefinition("constructorUserRepository", constructorReferenceBeanDefinition);
        beanFactory.registerBeanDefinition("setterUserRepository", setterReferenceBeanDefinition);



        User constructorUser = beanFactory.getBean("constructorUser",User.class);
        User setterUser = beanFactory.getBean("setterUser",User.class);
        UserReference userRepository = beanFactory.getBean("constructorUserRepository", UserReference.class);
        UserReference setterUserRepository = beanFactory.getBean("setterUserRepository",UserReference.class);
        System.out.println(constructorUser);
        System.out.println(setterUser);
        System.out.println(userRepository);
        System.out.println(setterUserRepository);
    }


    /**
     * set引用注入
     * @return
     */
    private static BeanDefinition createBeanDefinitionBySetterReference() {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserReference.class);

        beanDefinitionBuilder.addPropertyReference("user", "setterUser");

        return beanDefinitionBuilder.getBeanDefinition();

    }


    /**
     * 构造器引用注入
     * @return
     */
    private static BeanDefinition createBeanDefinitionByConstructorReference() {

       BeanDefinitionBuilder beanDefinitionBuilder  = BeanDefinitionBuilder.genericBeanDefinition(UserReference.class);

       beanDefinitionBuilder.addConstructorArgReference("constructorUser");

       return beanDefinitionBuilder.getBeanDefinition();

    }


    /**
     * 构造器注入
     * @return
     */
    private static BeanDefinition createBeanDefinitionByConstructor() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addConstructorArgValue(1);
        beanDefinitionBuilder.addConstructorArgValue("李白");
        beanDefinitionBuilder.addConstructorArgValue(18);
        return beanDefinitionBuilder.getBeanDefinition();

    }


    /**
     * set注入
     * @return
     */
    private static BeanDefinition createBeanDefinitionBySetter() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",2);
        beanDefinitionBuilder.addPropertyValue("name","222");
        beanDefinitionBuilder.addPropertyValue("age",20);
        return beanDefinitionBuilder.getBeanDefinition();

    }
}
