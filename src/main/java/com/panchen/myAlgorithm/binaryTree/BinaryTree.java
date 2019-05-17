package com.panchen.myAlgorithm.binaryTree;

/**
 * 
 * 
 * 
 * @author 二叉树 遍历
 *
 */
public class BinaryTree {


    public class Node {
        public int value;

        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }

    // 前序遍历：根结点 ---> 左子树 ---> 右子树

    // 中序遍历：左子树---> 根结点 ---> 右子树

    // 后序遍历：左子树 ---> 右子树 ---> 根结点

    // 先序
    private void preOrderRecurByStack(Node head) {
        if (null != head) {
            System.out.println(head.getValue());
            preOrderRecurByStack(head.getLeft());
            preOrderRecurByStack(head.getRight());
        }
    }


    // 中序
    private void inOrderRecurByStack(Node head) {
        if (null != head) {
            inOrderRecurByStack(head.getLeft());
            System.out.println(head.getValue());
            inOrderRecurByStack(head.getRight());
        }
    }

    // 后序
    private void posOrderRecurByStack(Node head) {
        if (head != null) {
            posOrderRecurByStack(head.getLeft());
            posOrderRecurByStack(head.getRight());
            System.out.println(head.getValue());
        }
    }
}
