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


    // 找到二叉树中的最大搜索二叉子树
    // 二叉搜索树 :
    // 或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    // 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
    private Node biggestSubBST(Node head) {
        return posOrderForBiggestSubBST(head, new int[3]);
    }

    private Node posOrderForBiggestSubBST(Node head, int[] record) {
        if (head == null) {
            
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        Node lBST = posOrderForBiggestSubBST(left, record);
        int lSize = record[0];
        int lmin = record[1];
        int lmax = record[2];

        Node rBST = posOrderForBiggestSubBST(left, record);
        int rSize = record[0];
        int rmin = record[1];
        int rmax = record[2];

        record[1] = lmin >= value ? value : lmin;
        record[2] = rmax >= value ? rmax : value;
        if (left == lBST && right == rBST && lmax < value && value < rmin) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = lSize >= rSize ? lSize : rSize;
        return lSize > rSize ? lBST : rBST;

    }
}
