package base.leetcode.questionofinterview.Zingfront;

import java.util.*;

/**
 * @author admin
 * @date 2020-06-12 9:58
 *
 * 计算最大差值
 * 有两组数，第一组数顺序固定，请编程实现让第二组数 相邻数字间的大小关系和第一组数相同，且
 * 第二组相邻数字间的差值之和最大
 * 下面给出一个示例例
 * 第一组数： 5 7 4 9
 * 第二组数：1 2 3  4
 * 第二组数排序结果：2 4 1 3
 * 第二组数排序后的差值之和：7  = abs(2-4) + abs(4-1) + abs(1-3)
 */
public class FiveQuestion {

    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();

        one.add(5);
        one.add(7);
        one.add(4);
        one.add(9);

        Map<Integer,Integer> position = new HashMap<>();


        List<Integer> two = new ArrayList<>();

        two.add(1);
        two.add(2);
        two.add(3);
        two.add(4);

        List<Integer> copyOne = new ArrayList<Integer>(one);

        Collections.sort(copyOne);

        for (int i=0;i<one.size();i++){
            position.put(i, copyOne.indexOf(one.get(i)));
        }
        Collections.sort(two);
        List<Integer> twoResult = new ArrayList<>(two);

        for (Integer i:position.keySet()
             ) {
            twoResult.set(i,two.get(position.get(i)) );
        }

        int result = 0;
        for (int i = twoResult.size()-1;i>0;i--){
            result+=Math.abs(twoResult.get(i)-twoResult.get(i-1));
        }

        System.out.println(result);


    }
}
