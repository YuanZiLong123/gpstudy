package com.yzl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020-07-25 10:20
 */
public class ThreadTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i=0;i<10000;i++){
            list.add("this is "+i);
        }

        for (int i=0;i<10;i++){

            List<String> stringList = list.subList(i*1000,(i+1)*1000 );
            new MyThread(stringList).start();
        }
    }
}

class MyThread extends Thread{

    private List<String> strings;

    public MyThread(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        System.out.println(this.getName());
        for (String str:strings){
            System.out.println(str);

        }
        System.out.println("***************************************");

    }
}
