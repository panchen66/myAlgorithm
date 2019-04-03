package com.panchen.myAlgorithm;

/**
 * 
 * 反转链表
 * 
 * 題目来源: 程序员代码面试指南 IT名企算法与数据结构题目最优解
 * 
 * @author panchen
 *
 */
public class ReversalLinkedList {

	public class Node {
		public int value;
		public Node next;
	}

	public class DoubleNode {
		public int value;
		public DoubleNode next;
		public DoubleNode pre;
	}

	public Node reversal(Node head) {
		// 倒转的next
		Node pre = null;
		// 用来暂存next
		Node next = null;
		while (null != head) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;

	}

	public Node reversalFT(Node head, int from, int to) {
		Node fNode = null;
		Node tNode = null;
		Node tmp = head;
		int i = 1;
		while (tmp != null) {
			if (i == from - 1) {
				fNode = tmp;
			}
			if (i == to + 1) {
				tNode = tmp;
			}
			tmp = tmp.next;
		}
		if (null == fNode || null == tNode) {
			return head;
		}

		// 开始反转 fNode-tNode
		Node n = fNode.next;
		Node pre = tNode;
		Node next = null;

		while (n != tNode) {
			next = n.next;
			n.next = pre;
			pre = n;
			n = next;
		}

		fNode.next = n;

		return head;
	}

	public DoubleNode reversalDouble(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (null != head) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;
		}
		return pre;
	}

}
