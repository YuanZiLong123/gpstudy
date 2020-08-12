package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.SuperUser;
import com.yzl.bean.lifecycle.entity.SuperUserProxy;
import com.yzl.bean.lifecycle.entity.User;
import com.yzl.bean.lifecycle.entity.UserHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 *
 * instantiation  实例化 没有对象生成
 * @author admin
 * @date 2020-08-11 9:43
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {

        if (StringUtils.equals(s,"superUser")&&aClass.equals(SuperUser.class)){
            SuperUserProxy superUserProxy =  new SuperUserProxy();


            return superUserProxy;
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName,"user")&& User.class.equals(bean.getClass())){

            User user = User.class.cast(bean);

            user.setId(99L);
            user.setName("66");


            return false;

        }

        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {

        if (StringUtils.equals(beanName,"userHolder")&&UserHolder.class.equals(UserHolder.class)){


            final MutablePropertyValues propertyValues;

            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues) pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }
            if (propertyValues.contains("version")){
                propertyValues.removePropertyValue("version");
                propertyValues.addPropertyValue("version",3);
            }

            propertyValues.addPropertyValue("describe","版本升级 2->3");
            System.out.println("版本升级 2->3");
        }

        return null;
    }

}