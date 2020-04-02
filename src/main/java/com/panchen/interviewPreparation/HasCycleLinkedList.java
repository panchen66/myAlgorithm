package com.panchen.interviewPreparation;


/**
 * @Description: 二、寻找环的入口点
 * <p>
 * 其中一个回到起点：
 * <p>
 * 当fast按照每次2步，slow每次一步的方式走，发现fast和slow重合，确定了单向链表有环路。接下来，让fast回到链表的头部，重新走，每次步长1，那么当fast和slow再次相遇的时候，就是环路的入口了。
 * <p>
 * 证明：
 * <p>
 * 在fast和slow第一次相遇的时候，假定slow走了n步，环路的入口是在p步，那么
 * <p>
 * 　　slow走的路径： p+c ＝ n；(1) c为fast和slow相交点 距离环路入口的距离
 * <p>
 * 　　fast走的路径： p+c+k*L = 2*n；(2), L为环路的周长，k是整数
 * <p>
 * 　　fast从头开始走，步长为1.
 * <p>
 * 　　经过n步，fast和slow都会到达p + c这一点。将(2)-(1)得k*L = n，说明n是L的倍数，同时p + c = n，
 * <p>
 * 　　所以fast和slow都走p步时，fast距(p + c)差c，slow还差c回到(p + c)，所以p是他们的第一个交点，之后的轨迹就一模一样了。
 * @author: chenp
 * @date: 2020/03/31 11:08
 */
public class HasCycleLinkedList {

    static class Node {

        Node(String data) {
            this.data = data;
        }


        void setNext(Node next) {
            this.next = next;
        }

        Node next;
        String data;
    }

    public static void main(String[] args) {

        Node root = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        root.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(c);
        hasCycle(root);
    }

    private static boolean hasCycle(Node root) {
        if (null == root && null == root.next) {
            return false;
        }
        Node fast = root;
        Node slow = root;
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
