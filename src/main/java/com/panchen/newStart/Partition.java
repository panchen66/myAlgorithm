package com.panchen.newStart;

/**
 * @Description: 86. 分隔链表 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。 示例: 输入: head = 1->4->3->2->5->2, x = 3 输出: 1->2->2->4->3->5
 *
 * 刚开始一直没看懂题目
 *
 * 其实就是比x小的动 大的不动
 *
 * 理解能力捉急，，  题解双链表再组合  没自己写 摘自Connor°
 *
 * @author: chenp
 * @date: 2020/06/30 20:10
 */
public class Partition {

    public static void main(String[] args) {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode5 = new ListNode(5);
        ListNode ListNode22 = new ListNode(2);

        ListNode1.next = ListNode4;
        ListNode4.next = ListNode3;
        ListNode3.next = ListNode2;
        ListNode2.next = ListNode5;
        ListNode5.next = ListNode22;

        System.out.println(partition(ListNode1, 3));
    }


    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode minLink = new ListNode(0);//记录小值链表的头
        ListNode minP = minLink;//对小表操作用的指针

        ListNode maxnLink = new ListNode(0);//记录大值链表的头
        ListNode maxP = maxnLink;//同理

        while (head != null) {
            if (head.val < x) {//找到小的值

                minP.next = head;//放入minLink中，操作指针后移一位
                minP = head;

            } else {

                maxP.next = head;//放入maxLink中，操作指针后移一位
                maxP = head;

            }
            head = head.next;
        }
        //遍历完成后记得后一段链表的最后节点指向null;
        maxP.next = null;
        //两段拼接
        minP.next = maxnLink.next;

        return minLink.next;
    }


}
