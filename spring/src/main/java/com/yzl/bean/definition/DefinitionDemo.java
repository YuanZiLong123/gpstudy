package com.yzl.bean.definition;

import com.yzl.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author admin
 * @date 2020-08-06 14:06
 */
public class DefinitionDemo {

    public static void main(String[] args) {

        //1.bean的定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);


        //2.bean的
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        genericBeanDefinition.setBeanClass(User.class);
    }

}
