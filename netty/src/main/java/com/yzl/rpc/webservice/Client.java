package com.yzl.rpc.webservice;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/10/30
 */
public class Client {


    public static void main(String[] args) {
        SayHelloService service=new SayHelloService();
        SayHello sayHello=service.getSayHelloPort();
        System.out.println(sayHello.sayHello("Mic"));
    }
}
