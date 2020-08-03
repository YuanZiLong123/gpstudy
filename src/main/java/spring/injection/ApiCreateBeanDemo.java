package spring.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import spring.pojo.User;

/**
 * @author admin
 * @date 2020-07-31 9:23
 */
public class ApiCreateBeanDemo {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition constructorBeanDefinition = createBeanDefinitionByConstructor();
        BeanDefinition setterBeanDefinition = createBeanDefinitionBySetter();

        beanFactory.registerBeanDefinition("constructorUser", constructorBeanDefinition);
        beanFactory.registerBeanDefinition("setterUser", setterBeanDefinition);

        User constructorUser = beanFactory.getBean("constructorUser",User.class);
        User setterUser = beanFactory.getBean("setterUser",User.class);
        System.out.println(constructorUser);
        System.out.println(setterUser);
    }

    private static BeanDefinition createBeanDefinitionByConstructor() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addConstructorArgValue(1);
        beanDefinitionBuilder.addConstructorArgValue("李白");
        beanDefinitionBuilder.addConstructorArgValue(18);
        return beanDefinitionBuilder.getBeanDefinition();

    }

    private static BeanDefinition createBeanDefinitionBySetter() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addConstructorArgValue(2);
        beanDefinitionBuilder.addConstructorArgValue("222");
        beanDefinitionBuilder.addConstructorArgValue(20);
        return beanDefinitionBuilder.getBeanDefinition();

    }
}
