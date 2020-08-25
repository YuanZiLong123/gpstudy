package com.yzl.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020-08-24 14:23
 */
@Aspect
@Component
public class JDKAnimalAop {

    @Pointcut("execution(* com.yzl.aop.Animal.run())")
    public void run(){}


    @Before("run()")
    public void before(){
        System.out.println("before run");
    }

    @After("run()")
    public void after(){
        System.out.println("after run");
    }
}
