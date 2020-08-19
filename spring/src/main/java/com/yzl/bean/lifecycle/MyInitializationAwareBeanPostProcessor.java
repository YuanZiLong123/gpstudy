package com.yzl.bean.lifecycle;

import com.yzl.bean.lifecycle.entity.City;
import com.yzl.bean.lifecycle.entity.User;
import com.yzl.bean.lifecycle.entity.UserHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 *   initialization 初始化  对象已经生成，属性赋值
 * @author admin
 * @date 2020-08-11 9:43
 */
public class MyInitializationAwareBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName, "user")&& User.class.equals(bean.getClass())){
            User user = User.class.cast(bean);

            user.setCity(City.BEIJING);
            user.setId(100L);
            user.setName("007");

            return user;
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (StringUtils.equals(beanName, "userHolder")&& UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = UserHolder.class.cast(bean);

            userHolder.setVersion(2);
            userHolder.setDescribe("版本升级 1->2");

            return userHolder;
        }
        return null;
    }


}