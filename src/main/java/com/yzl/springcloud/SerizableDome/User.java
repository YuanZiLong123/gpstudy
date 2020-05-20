package com.yzl.springcloud.SerizableDome;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/10/29
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4270822303518532753L;

    private  String name;

    private Integer age;

    public static  String id = "asd";

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        User.id = id;
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
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
