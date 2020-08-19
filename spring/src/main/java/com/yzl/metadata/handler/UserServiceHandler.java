package com.yzl.metadata.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author admin
 * @date 2020-08-17 10:02
 */
public class UserServiceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        // 将 "user" 元素注册对应的 BeanDefinitionParser 实现
        registerBeanDefinitionParser("user", new UserServiceBeanDefinitionParser());
    }
}
