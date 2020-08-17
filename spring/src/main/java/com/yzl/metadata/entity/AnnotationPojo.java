package com.yzl.metadata.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author admin
 * @date 2020-08-14 13:38
 */
@Component
public class AnnotationPojo {


    private Long id;

    private String name;

    @PostConstruct
    public void postConstruct(){
        this.id=7L;
        this.name="007";

    }

    @Override
    public String toString() {
        return "AnnotationPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
