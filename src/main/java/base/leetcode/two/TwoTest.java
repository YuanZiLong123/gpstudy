package base.leetcode.two;

import lombok.val;

/**
 * @author admin
 * @date 2020-06-02 17:26
 */
public class TwoTest {



    public static void main(String[] args) {
        ListNode oneNode = new ListNode(2);

        oneNode.next = new ListNode(4);

        oneNode.next.next = new ListNode(6);

        ListNode twoNode = new ListNode(5);

        twoNode.next = new ListNode(6);

        twoNode.next.next = new ListNode(4);
        twoNode.next.next.next = new ListNode(4);

         ListNode result = addTwoNumbers(oneNode,twoNode );

         while (null != result){
             System.out.println(result.val);
             result = result.next;
         }
    }


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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode param = result;

        int carry =0;
        while (l1 !=null || l2 != null){
            int num1 = null == l1?0: l1.val;
            int num2 = null == l2?0: l2.val;

            int number = num1+num2;
            int val = carry;
            if (number>=10){
                val +=number-10;
                carry = 1;
            }else {
                val += number;
                carry = 0;
            }
            param.next = new ListNode(val);
            param = param.next;

            if (null != l1){
                l1 = l1.next;
            }
            if (null != l2){
                l2 = l2.next;
            }

        }
        if (carry==1){
            param.next = new ListNode(carry);
        }

        return result.next;
    }


    public static ListNode addTwoNumbersStandardAnswer(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

}
