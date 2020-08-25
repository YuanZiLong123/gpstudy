package com.yzl.desigt.template.template.interfacepack;

public interface ICreateCar {


     default void createCar(){

        System.out.println("开始生产汽车");

        //打造模型
        createModel();

        //组装
        pack();

        //上色
        upColor();

        //上logo
        upLogo();

        System.out.println("生产汽车结束");

    }

   void upLogo();

    default   void upColor(){
        System.out.println("给汽车上色");
    }

    default   void pack(){
        System.out.println("组装汽车");
    }

    void createModel();


}
