package com.yzl.bean.lifecycle.entity;

/**
 * @author admin
 * @date 2020-08-07 9:14
 */
public class SuperUser  extends  User{

    private String nowAddress;

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "nowAddress='" + nowAddress + '\'' +
                "} " + super.toString();
    }
}
