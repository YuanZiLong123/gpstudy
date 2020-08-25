package com.yzl.converter;

import java.util.Properties;

/**
 * @author admin
 * @date 2020-08-25 10:15
 */
public class Person {

    private Long id;

    private String name;

    private Properties content;

    private String propertiesContent;


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

    public Properties getContent() {
        return content;
    }

    public void setContent(Properties content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content=" + content +
                ", propertiesContent='" + propertiesContent + '\'' +
                '}';
    }

    public String getPropertiesContent() {
        return propertiesContent;
    }

    public void setPropertiesContent(String propertiesContent) {
        this.propertiesContent = propertiesContent;
    }
}
