package netty.myrpc.impl;

import netty.myrpc.api.MyInterface;

/**
 * @author admin
 * @date 2020-06-01 14:30
 */
public class MyIntefaceImpl implements MyInterface {
    @Override
    public String hello(String name) {
        return "你好，"+name;
    }
}
