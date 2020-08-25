package com.yzl.desigt.proxy.staticproxy;


import com.yzl.desigt.proxy.People;

public class StaticProxyTest {


    public static void main(String[] args) {
        People people = new People();

        StaticProxy staticProxy = new StaticProxy(people);

        staticProxy.wantToDo();

    }
}
