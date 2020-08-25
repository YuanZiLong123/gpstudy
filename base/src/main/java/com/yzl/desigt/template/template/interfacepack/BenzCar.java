package com.yzl.desigt.template.template.interfacepack;


public class BenzCar implements ICreateCar {

    @Override
    public void upLogo() {
        System.out.println("上奔驰的logo");
    }

    @Override
    public void createModel() {
        System.out.println("生产奔驰的车型");
    }
}
