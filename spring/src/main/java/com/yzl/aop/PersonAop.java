package com.yzl.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020-08-24 14:06
 */
@Component
@Aspect
public class PersonAop {


    @Pointcut("execution(* com.yzl.aop.Person.say())")
    public void pointcut(){

    }


    @Before("pointcut()")
    public void before(){
        System.out.println("this is before");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("this is after");
    }

}



