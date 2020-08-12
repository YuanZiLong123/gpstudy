package com.yzl.classloader;

import org.springframework.beans.BeansException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;

/**
 * @author admin
 * @date 2020-08-10 17:23
 */
public class CastNullTest {

    public static void main(String[] args) {
        Integer integer = new Integer(11);

        Class<Integer> integerClass = null;

        System.out.println( doGetBean(integer, integerClass ));
    }


    public static <T> T doGetBean(final Object bean, @Nullable final Class<T> requiredType) throws BeansException {


        return (T) bean;
    }
}
