package com.yzl.netty.myrpc.api;

import com.yzl.netty.myrpc.model.User;

import java.util.List;

/**
 * @author admin
 * @date 2020-06-01 16:07
 */
public interface JdbcInterface {

    boolean add(User user);

    boolean delete(Integer id);

    boolean update(User user);

    List<User> select();

    User selectById(Integer id);



}
