package com.yzl.pojo;

/**
 * @author admin
 * @date 2020-08-06 9:23
 */
public class SingletonObject {

    private static SingletonObject singletonObject = new SingletonObject();


    private SingletonObject(){

    }


    public static SingletonObject getInstance(){
        return singletonObject;
    }


    @Override
    public String toString() {
        return "SingletonObject{这是一个单例}";
    }
}
