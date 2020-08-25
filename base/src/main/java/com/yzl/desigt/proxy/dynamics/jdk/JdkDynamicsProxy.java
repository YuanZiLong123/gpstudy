package com.yzl.desigt.proxy.dynamics.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicsProxy implements InvocationHandler {

    private Object behavior;

    public  Proxy getInstance(Object object){
        behavior = object;
        return (Proxy) Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    private  void before(){
        System.out.println("我是代理人，你可以要我做任何事");

    }

    private void after(){
        System.out.println("我已经帮你做完了 ");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.behavior,args);
        after();
        return object;
    }
}
