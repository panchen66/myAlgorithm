package com.panchen.newStart;

/**
 * @Description: 19. 删除链表的倒数第N个节点 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 来题经典链表题
 * <p>
 * 单向链表 只有头 那只能一直遍历到尾 再回来？
 * <p>
 * 看了个双指针法
 * @author: chenp
 * @date: 2020/05/08 18:48
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        //辅助节点  这个思路！！
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //first走得比second快n步
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        //当first到尾了 说明second也到了倒数N的位置
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //断链 n
        second.next = second.next.next;
        return dummy.next;

    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
