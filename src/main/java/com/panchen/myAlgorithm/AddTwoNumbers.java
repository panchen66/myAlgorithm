package com.panchen.myAlgorithm;

/**
 * 
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 *               如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 *               您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 *               示例：
 * 
 *               输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 *               来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * @author: chenp
 *
 * @date: 2019/09/19 15:18:12
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor = new ListNode(0);
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return cursor.next;

    }

}
