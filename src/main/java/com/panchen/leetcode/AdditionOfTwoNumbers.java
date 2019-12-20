package com.panchen.leetcode;

/**
 * @Description: leetcode 2
 * @author: chenp
 * @date: 2019/12/19 17:26
 */
public class AdditionOfTwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        // l1.next = new ListNode(2);

        ListNode l2 = new ListNode(9);
        ListNode ln2 = new ListNode(9);
        // ln2.next = new ListNode(4);
        l2.next = ln2;

        addTwoNumbers(l1, l2, 0, new ListNode(0));
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry, ListNode res) {
        int v1 = 0;
        int v2 = 0;
        int sum;
        if (null != l1) {
            v1 = l1.val;
        }
        if (null != l2) {
            v2 = l2.val;
        }
        sum = v1 + v2 + carry;
        res.val = sum % 10;
        carry = sum / 10;
        ListNode l1Next = null;
        if (l1 != null && l1.next != null) {
            l1Next = l1.next;
        }
        ListNode l2Next = null;
        if (l2 != null && l2.next != null) {
            l2Next = l2.next;
        }
        if (carry != 0 || (l1Next != null || l2Next != null)) {
            res.next = addTwoNumbers(l1Next, l2Next, carry, new ListNode(0));
        }
        return res;
    }


}
