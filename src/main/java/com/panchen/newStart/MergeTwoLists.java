package com.panchen.newStart;

/**
 * @Description: 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4\
 * <p>
 * <p>
 * 思考： 我认为就是把一个链表插入到另一个链表的过程
 * <p>
 * 看了leetcode 解法: 设置个虚节点 判断2个链表大小顺序接入虚节点
 * @author: chenp
 * @date: 2020/04/21 17:38
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        a2.next = a3;
        a1.next = a2;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        b2.next = b3;
        b1.next = b2;

        System.out.println(mergeTwoLists(a1, b1));
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //虚节点
        ListNode res = new ListNode(-1);

        //调度指针
        ListNode listNode = res;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        return res.next;
    }

}
