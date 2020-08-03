package base.code;

import java.util.Random;

/**
 * @author admin
 * @date 2020-07-23 15:29
 */
public class InitTest {

    public static void main(String[] args) {
        int[] array = new int[10000];

        Random random = new Random();
        for (int i=0;i<10000;i++){

            array[i] = random.nextInt(10000);

        }
        show(array);
        long time1 = System.currentTimeMillis();

        sort(array);
        show(array);
        long time2 = System.currentTimeMillis();

        directSort(array);
        show(array);
        long time3 = System.currentTimeMillis();


        System.out.println(time2-time1);
        System.out.println(time3-time2);


    }

    private static void show(int[] array) {

        for (int number:array
             ) {
            System.out.print(number);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void sort(int[] array){

        for (int i=1;i<array.length;i++){
            for (int j = 0;j<array.length-1;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] =array[j+1];
                    array[j+1]=temp;
                }
            }
        }


    }
    public static void directSort(int[] array){


        for (int i=0;i<array.length;i++){

            for (int j =i;j<array.length;j++){
                if (array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
