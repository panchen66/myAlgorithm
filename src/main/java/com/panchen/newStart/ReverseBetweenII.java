package com.panchen.newStart;

import java.util.Queue;
import java.util.Stack;

/**
 * @Description: leetcode 92. 反转链表 II 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明: 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4 输出: 1->4->3->2->5->NULL
 * <p>
 * 头插法? 学到了  确认一个头节点 不停地把要转置的节点 追加到头结点后面
 * @author: chenp
 * @date: 2020/07/08 17:53
 */
public class ReverseBetweenII {


    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;


    }


}
