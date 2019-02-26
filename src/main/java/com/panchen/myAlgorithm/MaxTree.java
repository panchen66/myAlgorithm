package com.panchen.myAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 构造数组的maxTree
 * 
 * 題目来源: 程序员代码面试指南 IT名企算法与数据结构题目最优解
 * 
 * @author panchen
 *
 */
public class MaxTree {


    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            super();
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    static Node MaxTree(int[] arr) {
        Node[] result = new Node[arr.length];
        Map<Node, Node> lBigMap = new HashMap<>();
        Map<Node, Node> rBigMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            result[i] = new Node(arr[i]);
        }
        // 查找左最近大值
        for (Node n : result) {
            while (!stack.isEmpty() && stack.peek().getValue() < n.getValue()) {
                popNodeToMap(stack, lBigMap);
            }
            stack.push(n);
        }
        // 清理stack里遺留的逆序
        while (!stack.isEmpty()) {
            popNodeToMap(stack, lBigMap);
        }
        // 查找右最近大值
        for (int i = result.length - 1; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek().getValue() < result[i].getValue()) {
                popNodeToMap(stack, rBigMap);
            }
            stack.push(result[i]);
        }
        // 清理stack里遺留的逆序
        while (!stack.isEmpty()) {
            popNodeToMap(stack, rBigMap);
        }
        Node h = null;
        // 建node关联
        for (Node n : result) {
            Node lb = lBigMap.get(n);
            Node rb = rBigMap.get(n);
            if (null == lb && null == rb) {
                h = n;
            } else if (null == lb) {
                if (rb.left == null) {
                    rb.left = n;
                } else {
                    rb.right = n;
                }
            } else if (null == rb) {
                if (lb.left == null) {
                    lb.left = n;
                } else {
                    lb.right = n;
                }
            } else {
                Node p = lb.getValue() > rb.getValue() ? rb : lb;
                if (p.left == null) {
                    p.left = n;
                } else {
                    p.right = n;
                }
            }
        }
        return h;

    }

    // 生成当前遍历到节点 前1-n(比当前节点小)个节点的 最近大节点映射
    static void popNodeToMap(Stack<Node> stack, Map<Node, Node> map) {
        Node n = stack.pop();
        if (stack.isEmpty()) {
            map.put(n, null);
        } else {
            map.put(n, stack.peek());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7, 13, 1, 4, 2, 99, 1313, 102, 103};
        Node result = MaxTree(arr);
        System.out.println("OK");
    }
}
