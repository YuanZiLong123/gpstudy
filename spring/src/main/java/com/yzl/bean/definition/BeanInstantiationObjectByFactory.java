package com.yzl.bean.definition;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author admin
 * @date 2020-08-06 14:38
 */
public class BeanInstantiationObjectByFactory implements FactoryBean {


    @Override
    public Object getObject() throws Exception {

        System.out.println("根据工厂实现实例");
        return new BeanInstantiationObjectByFactory();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanInstantiationObjectByFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
