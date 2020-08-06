package com.yzl.bean.definition;

/**
 * @author admin
 * @date 2020-08-06 14:38
 */
public class BeanInstantiationObjectByStaticMethod {


    public static BeanInstantiationObjectByStaticMethod BeanInstantiationObjectByStaticMethod(){

        System.out.println("bean实例化 根据静态方法");
        return new BeanInstantiationObjectByStaticMethod();
    }

}
