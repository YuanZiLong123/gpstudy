package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.UserHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author admin
 * @date 2020-08-12 15:31
 */
public class MyDestroyAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if ( UserHolder.class.equals(bean.getClass())){
            System.out.println("这里是bean的销毁阶段");
        }
    }

}
