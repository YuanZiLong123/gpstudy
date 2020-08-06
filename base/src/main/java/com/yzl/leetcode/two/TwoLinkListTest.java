package base.leetcode.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 * @date 2020-06-02 16:10
 */
public class TwoLinkListTest {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */


    public static void main(String[] args) {
        LinkedList<Integer> one = new LinkedList();
        LinkedList<Integer> two = new LinkedList();

        one.add(2);
        one.add(4);
        one.add(3);

        two.add(5);
        two.add(6);
        two.add(4);

        Long tim1 = System.currentTimeMillis();
        List<Integer> result = sumByList(one,two);
        Long tim2 = System.currentTimeMillis();
        System.out.println(tim2-tim1);


        Long tim3 = System.currentTimeMillis();
        List<Integer> result2 = sum(one,two);
        Long tim4 = System.currentTimeMillis();
        System.out.println(tim4-tim3);

        System.out.println(result.toString());
        System.out.println(result2.toString());
    }


    private static List<Integer> sum(LinkedList<Integer> one ,LinkedList<Integer> two){
        List<Integer> linkedList = new LinkedList<>();
        int parm1 = 0;
        int parm2 = 0;

        for (int i=0;i<one.size();i++){
            int num = one.get(i);
            if (num<0){
                throw  new IllegalArgumentException("参数有误");
            }

           parm1 += Math.pow(10, i)*num;
        }
        for (int i=0;i<two.size();i++){
            int num = two.get(i);
            if (num<0){
                throw  new IllegalArgumentException("参数有误");
            }

            parm2 += Math.pow(10, i)*num;
        }

        int result = parm1+parm2;

        String str = String.valueOf(result);
        for (int i = str.length();i>0;i--){
            linkedList.add( Integer.parseInt(String.valueOf(str.charAt(i-1))) );
        }
        return linkedList;
    }


    private static List<Integer> sumByList(LinkedList<Integer> one ,LinkedList<Integer> two){
        List<Integer> linkedList = new LinkedList<>();
        int result = 0;
        int length = one.size()>two.size()?one.size():two.size();

        for (int i = 0;i<length;i++){
            int num1 = i>=one.size()?0:one.get(i);
            int num2 = i>=two.size()?0:two.get(i);
            if (num1<0){
                throw  new IllegalArgumentException("参数有误");
            }

            if (num2<0){
                throw  new IllegalArgumentException("参数有误");
            }

            int  addNum =(int) Math.pow(10,i )*num1+(int)Math.pow(10,i )*num2;
            result +=addNum;
        }


        String str = String.valueOf(result);
        for (int i = str.length();i>0;i--){
            linkedList.add( Integer.parseInt(String.valueOf(str.charAt(i-1))) );
        }
        return linkedList;
    }


}
