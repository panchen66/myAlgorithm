
package com.panchen.myAlgorithm;

import java.util.Stack;

/**
 * @Description: 链表逆序输出
 * @author: chenp
 * @date: 2019/10/08 17:59
 */
public class InvertedLinkedList {

    static class LinkedListNode {

        int value;

        LinkedListNode next;


        LinkedListNode(int v, LinkedListNode next) {
            this.value = v;
            this.next = next;
        }


        void next(LinkedListNode next) {
            this.next = next;
        }

        int data() {
            return this.value;
        }
    }


    private static LinkedListNode getLinkedList() {
        LinkedListNode head = new LinkedListNode(0, null);
        LinkedListNode tmp = head;
        for (int i = 1; i < 10; i++) {
            LinkedListNode newNode = new LinkedListNode(i, null);
            tmp.next(newNode);
            tmp = newNode;
        }
        return head;

    }


    public static void inverseList(LinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.data());
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }

    }

    public static void main(String[] args) {
        LinkedListNode linkedList = getLinkedList();
        inverseList(linkedList);
    }


}
