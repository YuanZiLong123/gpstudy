package com.yzl.Zingfront;

/**
 * @author admin
 * @date 2020-06-11 18:00
 */
public class Item  implements Comparable<Item>{

    private String name;

    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Item(String name, Integer number) {
        this.name = name;
        this.number = number;
    }


    @Override
    public int compareTo(Item o) {
        return this.number-o.number;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
