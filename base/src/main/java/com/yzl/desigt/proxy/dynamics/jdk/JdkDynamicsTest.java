package com.yzl.desigt.proxy.dynamics.jdk;


import com.yzl.desigt.proxy.Behavior;
import com.yzl.desigt.proxy.People;

import java.lang.reflect.Proxy;

public class JdkDynamicsTest {


    public static void main(String[] args) {
        People people = new People();
        JdkDynamicsProxy dynamicsProxy = new JdkDynamicsProxy();
        Behavior proxy =(Behavior) new  JdkDynamicsProxy().getInstance(people);
        proxy.wantToDo();
    }
}
