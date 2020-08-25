package com.yzl.desigt.template.template.extend;

public class TemplateTest {

    public static void main(String[] args) {
        BWMCar bwmCar = new BWMCar();
        bwmCar.createCar();

        System.out.println("**********************************");

        BenzCar benzCar = new BenzCar();
        benzCar.createCar();
    }
}
