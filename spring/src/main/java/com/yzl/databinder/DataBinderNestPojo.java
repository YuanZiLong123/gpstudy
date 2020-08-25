package com.yzl.databinder;

/**
 * @author admin
 * @date 2020-08-25 9:34
 */
public class DataBinderNestPojo {


    private String address;

    private String description;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DataBinderNestPojo{" +
                "address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
