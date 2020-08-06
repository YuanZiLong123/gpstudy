package base.leetcode;

/**
 * @author admin
 * @date 2020-06-02 13:16
 */
public class SqrtTest {

    public static void main(String[] args) {
        int result = computer(30,30);

        System.out.println(result);
    }

    /**
     *  要求：
     *
     *     不能调用系统库函数，诸如 Math.sqrt(v) 之类的；
     *
     *     假设计算出的结果为 r，要求满足这个条件： |r-√v|<=t ，
     *     其中 √v是真实的值， t  为给定的一个误差范围，例如0.1等，
     *     即你计算出的值要在给定的误差范围内。
     *     实现语言不限，你条件可以比上述更加苛刻，但不能宽松。
     *     例如调用你的接口 sqrt(9, 0.21) 返回值属于 [2.79, 3.21] 这个区间的任意一个都满足条件。
      */


    double sqrt(int v, double t){

        int i =0;
        while (i*i == v){
            i++;
        }

        return i+t;
    }


    static int computer(int m,int n){

        int result = m;
        for (int i=0;i<n;i++){
            result+=(i+1)*i/2;
        }
        return result;
    }

}
