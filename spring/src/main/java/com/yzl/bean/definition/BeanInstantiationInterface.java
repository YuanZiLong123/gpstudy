package com.yzl.bean.definition;

/**
 * @author admin
 * @date 2020-08-06 14:46
 */
public interface BeanInstantiationInterface {

    default BeanInstantiationObjectByInstance createBeanInstantiationObjectByInstance(){

        System.out.println("根据实例（Bean）方法 实现其实例");
        return new BeanInstantiationObjectByInstance();
    }

}
