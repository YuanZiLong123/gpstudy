package base.leetcode.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2020-06-02 13:35
 */
public class OneTest {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */


    public static void main(String[] args) {
        int[] nums = new int[100000];
        int i = 0;
        while (i<100000){
            nums[i]=++i;
        }
        int target = 199999;
        long time1 = System.currentTimeMillis();
        int[] result = getSumArrayIndex(nums,target );
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println("下标为"+result[0]+"和"+result[1]);


        long time3 = System.currentTimeMillis();
        int[] otherResult = getSumArrayIndexByHashMap(nums,target );
        long time4 = System.currentTimeMillis();
        System.out.println(time4-time3);
        System.out.println("下标为"+otherResult[0]+"和"+otherResult[1]);


        long time5 = System.currentTimeMillis();
        int[] newResult = getSumArrayIndexByHashMapTwo(nums,target );
        long time6 = System.currentTimeMillis();
        System.out.println(time6-time5);
        System.out.println("下标为"+newResult[0]+"和"+newResult[1]);
    }


    /**
     * 暴力遍历所有数据
     * @param nums
     * @param target
     * @return
     */
    public static int[] getSumArrayIndex(int[] nums , int target)  {

        int length = nums.length;

        for (int i = 0;i<length-1;i++){
            for (int j = i+1;j<length;j++){
                if(nums[i]+nums[j]==target){
                    return  new int[]{i,j};
                }
            }
        }
        throw  new IllegalArgumentException("not find result");
    }


    /**
     * 两遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] getSumArrayIndexByHashMap(int[] nums , int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<nums.length;i++){
            map.put(nums[i],i );
        }

        for (int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) &&  map.get(complement) != i){
                return  new int[]{i,map.get(complement)};
            }
        }
        throw  new IllegalArgumentException("not find result");
    }


    /**
     * 一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] getSumArrayIndexByHashMapTwo(int[] nums , int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

}
