package base.leetcode.questionofinterview.Zingfront;

/**
 * @author admin
 * @date 2020-06-12 9:57
 * 有趣的两位数
 * 有数学家发现一些两位数很有意思，比如，
 * 34 * 86 = 43 * 68
 * 也就是说，如果把他们的十位数和个位数交换，二者乘积不变。
 * 编程求出满足该性质的两位数组合。
 * 提示，暴力解法非最优解。
 */
public class FourQuestion {


    public static void main(String[] args) {
dealWith2();

    }


    static void dealWith(){
        for (int n =10;n<100;n++){
            for (int m =10;m<100;m++){
                int i = n/10;
                int j = n%10;

                int q = m/10;
                int p=m%10;

                if (i!=j&&q!=p&& m*n == (10*j+i)*(10*p+q)){
                    System.out.println(n+"/"+m);
                }

            }
        }
    }

    static void dealWith2(){




       for ( int m = 1;m<10;m++){
           for (int n = 1;n<10;n++){
               for ( int i = 1;i<10;i++){
                   for (int j = 1;j<10;j++){
                       if (m*i ==n*j){
                           System.out.println(10*m+n+"/"+(10*i+j));
                       }
                   }
               }
           }
       }




    }
}
