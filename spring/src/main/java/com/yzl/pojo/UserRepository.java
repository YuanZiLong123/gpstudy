package com.yzl.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020-08-04 11:05
 */
@Component
public class UserRepository {

    @Autowired
    private User user;



    @Override
    public String toString() {
        return "UserResponsory{" +
                "user=" + user +
                '}';
    }
}
