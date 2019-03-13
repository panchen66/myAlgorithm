package com.panchen.myAlgorithm;

/**
 * 
 * 在单链表和双链表中删除倒数第K个节点
 * 
 * 題目来源: 程序员代码面试指南 IT名企算法与数据结构题目最优解
 * 
 * @author panchen
 *
 */
public class LinkedListDel {


    void removeLastNode(Node head, int last) {
        if (null == head || 1 > last) {
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            last--;
            tmp = tmp.next;
        }
        if (0 == last) {
            head = head.next;
            return;
        }
        if (0 > last) {
            tmp = head;
            while (last != 0) {
                last++;
                tmp = head.next;
            }
            tmp.next = tmp.next.next;
        }
    }

    void removeLastTwoWayNode(TwoWayNode head, int last) {
        if (null == head || 1 > last) {
            return;
        }
        TwoWayNode tmp = head;
        while (tmp.next != null) {
            last--;
            tmp = tmp.next;
        }
        if (0 == last) {
            head = head.next;
            return;
        }
        if (0 > last) {
            tmp = head;
            while (last != 0) {
                last++;
                tmp = tmp.next;
            }
            // 构造个新节点来承上启下
            TwoWayNode newNext = tmp.next.next;
            tmp.next = newNext;
            newNext.last = tmp;
        }
    }

    class Node {
        int value;
        Node next;
    }

    class TwoWayNode {
        int value;
        TwoWayNode next;
        TwoWayNode last;
    }

}
