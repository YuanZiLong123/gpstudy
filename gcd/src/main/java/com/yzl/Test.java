package com.yzl;

public class Test {



    public static void main(String[] args) {
       int j = 0;
        Test test = new Test();

        Thread inc1 = test.new IncThread(j);
        inc1.start();
        Thread inc2 = test.new IncThread(j);
        inc2.start();
        Thread dec1 = test.new DecThread(j);
        dec1.start();
        Thread dec2 = test.new DecThread(j);
        dec1.start();
    }


    class  IncThread extends  Thread{

        private int number ;

        public IncThread(int j){
        this.number = j;
        }

        @Override
        public void run() {
            number++;
        }
    }

    class DecThread extends  Thread{
        private int number ;

        public DecThread(int j){
            this.number = j;
        }

        @Override
        public void run() {
            number--;
        }
    }
}
