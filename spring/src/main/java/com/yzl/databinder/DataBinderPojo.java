package com.yzl.databinder;

/**
 * @author admin
 * @date 2020-08-25 9:33
 */
public class DataBinderPojo {


    private Long id;

    private String name;

    private DataBinderNestPojo dataBinderNestPojo;

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

    public DataBinderNestPojo getDataBinderNestPojo() {
        return dataBinderNestPojo;
    }

    public void setDataBinderNestPojo(DataBinderNestPojo dataBinderNestPojo) {
        this.dataBinderNestPojo = dataBinderNestPojo;
    }

    @Override
    public String toString() {
        return "DataBinderPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataBinderNestPojo=" + dataBinderNestPojo +
                '}';
    }
}
