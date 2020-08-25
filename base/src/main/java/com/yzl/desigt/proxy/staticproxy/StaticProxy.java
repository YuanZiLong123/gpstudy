package com.yzl.desigt.proxy.staticproxy;


import com.yzl.desigt.proxy.Behavior;
import com.yzl.desigt.proxy.People;

public class StaticProxy implements Behavior {

    private People people;

    public StaticProxy(People people) {
        this.people = people;
    }

    private  void before(){
        System.out.println("我是代理人，你可以要我做任何事");

    }

    private void after(){
        System.out.println("我已经帮你做完了 ");
    }

    @Override
    public void wantToDo() {
        before();
        people.wantToDo();
        after();
    }



}
