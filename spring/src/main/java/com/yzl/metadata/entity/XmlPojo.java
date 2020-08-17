package com.yzl.metadata.entity;

/**
 * @author admin
 * @date 2020-08-14 9:20
 */
public class XmlPojo {

    private Long id;

    private String name;

    @Override
    public String toString() {
        return "XmlPojo{" +
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
