package base.leetcode.questionofinterview.Zingfront;

import java.util.HashMap;

/**
 * @author admin
 * @date 2020-06-12 9:57
 *
 * 邀请码检测
 * 某产品的用户注册邀请码为⼀一串有小写字母和数字组成的字符串，字符串⻓长度为16。当用户数据邀
 * 请码的时候，系统需要对邀请码做有效性验证，假设验证规则如下：
 * 1、 从序列号最后⼀一位字符开始，逆向将奇数位(1、3、5等等)相加；
 * 2、从序列号最后⼀一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去
 * 9），再求和；
 * 3、将奇数位总和加上偶数位总和，结果可以被10整除；
 * 4、小写字母对应数值，可由下面键值对确定；
 * [(a,1), (b,2), (c,3)…,(i,9), (j,1), (k, 2)…]，亦即，按字母顺序，1-9循环。
 * 输⼊入：输⼊入16位字符串，表示邀请码
 * 输出：输出“ok”或者“error”
 */
public class TwoQuestion {

    private HashMap<String,Integer>  teeMap = new HashMap<>();

    private String teeStr = "abcdefghijklmnopqrstuvwxyz";


}
