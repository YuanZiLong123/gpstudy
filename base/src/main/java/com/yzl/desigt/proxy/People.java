package com.yzl.desigt.proxy;

public class People implements  Behavior {


    @Override
    public void wantToDo() {
        System.out.println("你要去做的事");
    }
}
