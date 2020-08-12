package com.yzl.three;


import java.util.*;

/**
 * @author admin
 * @date 2020-06-21 15:29
 */
public class Test {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     */

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int getLength(String s){
         List<String> cacheStr = new ArrayList<>();

         List<Integer> repetition = new ArrayList<>();
        char[] chars = s.toCharArray();
        int number = 0;
        for(int j=0;j<chars.length;j++){
            for (int i =j;i<chars.length;i++){
                char c = chars[i];
                if (cacheStr.contains(String.valueOf(c))){
                    cacheStr = new ArrayList<>();
                    repetition.add(number);
                    number=0;
                    break;
                }
                number++;
                cacheStr.add(String.valueOf(c) );
                if (i==chars.length-1){
                    repetition.add(number);
                }
            }
        }

        Collections.sort(repetition);
        return repetition.size()==0?s.length():repetition.get(repetition.size()-1);
    }


    public static void main(String[] args) {
        Test test = new Test();


        StringBuffer stringBuffer = new StringBuffer();

        for (int i=0;i<1000;i++){
            stringBuffer.append(UUID.randomUUID().toString().replaceAll("-","" ));
        }




        String str = stringBuffer.toString();

        Long tim1 = System.currentTimeMillis();
        System.out.println(test.getLength(str));
        Long tim2 = System.currentTimeMillis();
        System.out.println(tim2-tim1);


        Long tim3 = System.currentTimeMillis();
        System.out.println(test.lengthOfLongestSubstring(str));
        Long tim4 = System.currentTimeMillis();
        System.out.println(tim4-tim3);


    }
}
