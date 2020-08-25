package com.yzl.aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020-08-24 14:22
 */
public class Animal implements IRunAbleInterface {


    @Override
    public void run() {
        System.out.println("the animal can run");
    }
}
