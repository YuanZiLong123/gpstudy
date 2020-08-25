package com.yzl.desigt.template.template.extend;

public class BenzCar extends  AbstractCreateCar {
    protected void upLogo() {
        System.out.println("上奔驰的logo");
    }

    protected void createModel() {
        System.out.println("生产奔驰的车型");
    }
}
