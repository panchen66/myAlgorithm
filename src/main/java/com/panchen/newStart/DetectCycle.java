package com.panchen.newStart;

/**
 * @Description: leetcode 142. 环形链表 II 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 代码实现来自jyd  具体逻辑注释可见
 * @author: chenp
 * @date: 2020/07/15 16:07
 */
public class DetectCycle {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //环内第一次相遇  此时fast是slow的倍速度 2f f 可得 2f-f=nb b为环内周长
                break;
            }
        }
        // 综上假设要到交点 得走 a+nb a为从head到交点的距离 而slow已经走了nb 那就再走a呗 然后fast从head走a步 就2个点相遇在交点了
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
