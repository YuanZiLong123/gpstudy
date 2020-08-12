package com.yzl.jdk8;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author admin
 * @date 2020-07-03 13:39
 */
@Data
@Accessors(chain = true)
public class Person {

    private String name;

    private Integer age;

    private String sex;


    public Person() {
    }

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
