package com.yzl.pojo;

/**
 * @author admin
 * @date 2020-07-31 9:22
 */
public class User {


    private Long id;

    private String name;

    private Integer age;


    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}'+this.hashCode();
    }

    public static User createUser(){
        User user = new User();

        user.setId(System.nanoTime());

        return user;
    }
}
