package com.yzl.metadata.handler;

import com.yzl.metadata.service.impl.UserServiceImpl;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author admin
 * @date 2020-08-17 10:03
 */
public class UserServiceBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return UserServiceImpl.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {


    }
}
