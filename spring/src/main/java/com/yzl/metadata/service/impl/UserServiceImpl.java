package com.yzl.metadata.service.impl;

import com.yzl.metadata.service.IUserService;
import com.yzl.pojo.User;

/**
 * @author admin
 * @date 2020-08-17 9:53
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void printUser(User user) {
        System.out.println(user);
    }
}
