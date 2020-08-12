package com.yzl.bean.lifecycle.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020-08-07 9:12
 */
public class User {

    private Long id;

    private String name;

    private City city;


    private List<City> workCities;


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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getWorkCities() {
        return workCities;
    }

    public void setWorkCities(List<City> workCities) {
        this.workCities = workCities;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + workCities +
                '}';
    }
}
