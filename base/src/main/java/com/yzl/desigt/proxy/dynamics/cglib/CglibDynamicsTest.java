package com.yzl.desigt.proxy.dynamics.cglib;


public class CglibDynamicsTest  {


    public static void main(String[] args) {
        CglibDynamicsProxy cglibDynamicsProxy = new CglibDynamicsProxy();

        Customer proxy = null;
        try {
            proxy = (Customer) cglibDynamicsProxy.getInstance(Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        proxy.wantToDo();

    }
}
