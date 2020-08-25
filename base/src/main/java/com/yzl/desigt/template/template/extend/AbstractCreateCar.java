package com.yzl.desigt.template.template.extend;

public abstract class AbstractCreateCar {


    public void createCar(){

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

    protected abstract void upLogo();

    final  void upColor(){
        System.out.println("给汽车上色");
    }

    final  void pack(){
        System.out.println("组装汽车");
    }

    protected abstract void createModel();


}
