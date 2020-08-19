package com.yzl.pojo;

/**
 * @author admin
 * @date 2020-08-04 13:15
 */
public class UserReference {

    private User user;

    public UserReference() {
    }

    public UserReference(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserReference{" +
                "user=" + user +
                '}';
    }
}
