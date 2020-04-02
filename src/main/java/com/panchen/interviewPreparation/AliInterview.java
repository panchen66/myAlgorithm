package com.panchen.interviewPreparation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: 平时不努力 用时徒伤悲
 * @author: chenp
 * @date: 2020/03/31 18:54
 */
public class AliInterview {


    public static void main(String[] args) {
        Node n = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node res3 = reverseKGroup(n, 2);
        Node res2 = reverseListNode(n);
        Node res = solution(n, 2);
    }


    // leetcode   靠 重新再构造个就完事了 我tm非得自己搞个毛啊
    public static Node reverseKGroup(Node head, int k) {
        Deque<Node> stack = new ArrayDeque<Node>();
        Node dummy = new Node(0);
        Node p = dummy;
        while (true) {
            int count = 0;
            Node tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;

    }


    static class Node {

        Node(Integer data) {
            this.data = data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        Integer data;
        Node next;
    }


    public static Node solution(Node root, int k) {
        if (k == 0) {
            return root;
        }
        int count = 0;
        Node tmp = root;
        //Node swapInterval = null;
        // boolean needToSwapInterval = false;
        Queue q = new LinkedBlockingQueue();
        while (null != tmp) {
            count++;
        /*    if (needToSwapInterval) {
                swapInterval.next = tmp;
                needToSwapInterval = false;
            }*/
            q.add(tmp);
            if (count >= k && count % k == 0) {
                swap(q);
                for (int i = 1; i < k; i++) {
                    tmp = tmp.next;
                }
                // needToSwapInterval = true;
            }
            tmp = tmp.next;
        }
        return root;

    }


    public static Node reverseListNode(Node head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;//nextNode 指向下一个节点
            curNode.next = preNode;//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }

        return preNode;
    }

    private static Node swap(Queue<Node> q) {
        Node pre = null;
        Node pro = null;
        boolean isFirst = true;
        while (null != q.peek()) {
            if (isFirst) {
                pre = q.poll();
                isFirst = false;
            } else {
                pro = q.poll();
                pre = swap(pre, pro);
            }
        }
        return pre;
    }

    private static Node swap(Node pre, Node pro) {
        Node temp = pro.next;
        pro.next = temp.next;
        temp.next = pre.next;
        pre.next = temp;
        return pre;
    }
}
