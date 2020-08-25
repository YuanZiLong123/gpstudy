package com.yzl.desigt.template.template.interfacepack;

public class TemplateTest {

    public static void main(String[] args) {
        ICreateCar bwmCar = new BWMCar();
        bwmCar.createCar();

        System.out.println("**********************************");

        ICreateCar benzCar = new BenzCar();
        benzCar.createCar();
    }
}
