package com.yzl.bean.lifecycle.entity;

/**
 * SuperUser的代理类
 * @author admin
 * @date 2020-08-12 10:57
 */
public class SuperUserProxy extends SuperUser {


    @Override
    public String toString() {
        return "SuperUserProxy{} 我是superUser 的代理类" + super.toString();
    }
}
