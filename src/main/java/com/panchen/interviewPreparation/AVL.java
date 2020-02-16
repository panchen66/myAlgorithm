package com.panchen.interviewPreparation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 平衡二叉树   其中每一个节点的左子树和右子树的高度差至多等于1
 *
 *                             A
 *                     B                 C
 *                 D      E          F       G
 *                右旋   左右旋     右左旋    左旋
 *
 *
 *                A                         B
 *           B         C    右旋       D        A
 *       D     E                            E      C
 *
 *
 *                A                          C
 *          B          C      左旋         A     E
 *                 D      E            B     D
 *
 *                 摘自 https://www.cnblogs.com/qm-article/p/9349681.html
 *
 * @author: chenp
 * @date: 2020/02/15 16:12
 */
public class AVL {

    private int LEFT = 1;
    private int RIGHT = 0;

    private Node root;
    private int size;

    static class Node {

        Node parent;
        Node leftChild;
        Node rightChild;
        int val;

        public Node(Node parent, Node leftChild, Node rightChild, int val) {
            super();
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.val = val;
        }

        public Node(int val) {
            this(null, null, null, val);
        }

        public Node(Node node, int val) {
            this(node, null, null, val);
        }

    }


    public boolean put(int val) {
        return putVal(root, val);
    }

    private boolean putVal(Node node, int val) {
        if (node == null) {// 初始化根节点
            node = new Node(val);
            root = node;
            size++;
            return true;
        }
        Node temp = node;
        Node p;
        int t;
        /**
         * 通过do while循环迭代获取最佳节点，
         */
        do {
            p = temp;
            t = temp.val - val;
            if (t > 0) {
                temp = temp.leftChild;
            } else if (t < 0) {
                temp = temp.rightChild;
            } else {
                temp.val = val;
                return false;
            }
        } while (temp != null);
        Node newNode = new Node(p, val);
        if (t > 0) {
            p.leftChild = newNode;
        } else if (t < 0) {
            p.rightChild = newNode;
        }
        rebuild(p);// 使二叉树平衡的方法
        size++;
        return true;
    }


    private void rebuild(Node p) {
        while (p != null) {
            if (calcNodeBalanceValue(p) == 2) {// 说明左子树高，需要右旋或者 先左旋后右旋
                fixAfterInsertion(p, LEFT);// 调整操作
            } else if (calcNodeBalanceValue(p) == -2) {
                fixAfterInsertion(p, RIGHT);
            }
            p = p.parent;
        }
    }

    private int calcNodeBalanceValue(Node node) {
        if (node != null) {
            return getHeightByNode(node);
        }
        return 0;
    }

    // 计算node节点的高度
    public int getChildDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getChildDepth(node.leftChild), getChildDepth(node.rightChild));
    }

    public int getHeightByNode(Node node) {
        if (node == null) {
            return 0;
        }
        return getChildDepth(node.leftChild) - getChildDepth(node.rightChild);
    }


    private void fixAfterInsertion(Node p, int type) {
        // TODO Auto-generated method stub
        if (type == LEFT) {
            final Node leftChild = p.leftChild;
            if (leftChild.leftChild != null) {//右旋
                rightRotation(p);
            } else if (leftChild.rightChild != null) {// 先左旋后右旋
                leftRotation(leftChild);
                rightRotation(p);
            }
        } else {
            final Node rightChild = p.rightChild;
            if (rightChild.rightChild != null) {// 左旋
                leftRotation(p);
            } else if (rightChild.leftChild != null) {// 先右旋，后左旋
                rightRotation(p);
                leftRotation(rightChild);
            }
        }
    }


    public Node leftRotation(Node node) {
        if (node != null) {
            Node rightChild = node.rightChild;
            node.rightChild = rightChild.leftChild;
            if (rightChild.leftChild != null) {
                rightChild.leftChild.parent = node;
            }
            rightChild.parent = node.parent;
            if (node.parent == null) {
                this.root = rightChild;
            } else if (node.parent.rightChild == node) {
                node.parent.rightChild = rightChild;
            } else if (node.parent.leftChild == node) {
                node.parent.leftChild = rightChild;
            }
            rightChild.leftChild = node;
            node.parent = rightChild;

        }
        return null;
    }

    /**
     * @param bNode 代表B节点
     * @return
     */
    public Node rightRotation(Node bNode) {
        if (bNode != null) {
            Node cNode = bNode.rightChild;// 用临时变量存储C节点
            cNode.parent = bNode.parent;
            // 这里因为bNode节点父节点存在，所以不需要判断。加判断也行,
            if (bNode.parent.rightChild == bNode) {
                bNode.parent.rightChild = cNode;
            } else {
                bNode.parent.leftChild = cNode;
            }
            cNode.leftChild = bNode;
            bNode.parent = cNode;
            return cNode;
        }
        return null;
    }

    public Node getNode(int val){
        Node temp = root;
        int t;
        do{
            t = temp.val-val;
            if(t > 0){
                temp = temp.leftChild;
            }else if(t < 0){
                temp = temp.rightChild;
            }else{
                return temp;
            }
        }while(temp != null);
        return null;
    }

    /**
     *
     * 可见https://www.jianshu.com/p/2a8f2b3511fd
     * @param val
     * @return
     */
    public boolean delete(int val){
        Node node = getNode(val);
        if(node == null){
            return false;
        }
        boolean flag = false;
        Node p = null;
        Node parent = node.parent;
        Node leftChild = node.leftChild;
        Node rightChild = node.rightChild;
        //以下所有父节点为空的情况，则表明删除的节点是根节点
        if(leftChild == null && rightChild == null){//没有子节点
            if(parent != null){
                if(parent.leftChild == node){
                    parent.leftChild = null;
                }else if(parent.rightChild == node){
                    parent.rightChild = null;
                }
            }else{//不存在父节点，则表明删除节点为根节点
                root = null;
            }
            p = parent;
            node = null;
            flag =  true;
        }else if(leftChild == null && rightChild != null){// 只有右节点
            if(parent != null && parent.val > val){// 存在父节点，且node位置为父节点的左边
                parent.leftChild = rightChild;
            }else if(parent != null && parent.val < val){// 存在父节点，且node位置为父节点的右边
                parent.rightChild = rightChild;
            }else{
                root = rightChild;
            }
            p = parent;
            node = null;
            flag =  true;
        }else if(leftChild != null && rightChild == null){// 只有左节点
            if(parent != null && parent.val > val){// 存在父节点，且node位置为父节点的左边
                parent.leftChild = leftChild;
            }else if(parent != null && parent.val < val){// 存在父节点，且node位置为父节点的右边
                parent.rightChild = leftChild;
            }else{
                root = leftChild;
            }
            p = parent;
            flag =  true;
        }else if(leftChild != null && rightChild != null){// 两个子节点都存在
                Node successor = getSuccessor(node);// 这种情况，一定存在后继节点
            int temp = successor.val;
            boolean delete = delete(temp);
            if(delete){
                node.val = temp;
            }
            p = successor;
            successor = null;
            flag =  true;
        }
        if(flag){
            rebuild(p);
        }
        return flag;
    }

    /**
     * 找到node节点的后继节点
     * 1、先判断该节点有没有右子树，如果有，则从右节点的左子树中寻找后继节点，没有则进行下一步
     * 2、查找该节点的父节点，若该父节点的右节点等于该节点，则继续寻找父节点，
     *   直至父节点为Null或找到不等于该节点的右节点。
     * 理由，后继节点一定比该节点大，若存在右子树，则后继节点一定存在右子树中，这是第一步的理由
     *      若不存在右子树，则也可能存在该节点的某个祖父节点(即该节点的父节点，或更上层父节点)的右子树中，
     *      对其迭代查找，若有，则返回该节点，没有则返回null
     * @param node
     * @return
     */
    private Node getSuccessor(Node node){
        if(node.rightChild != null){
            Node rightChild = node.rightChild;
            while(rightChild.leftChild != null){
                rightChild = rightChild.leftChild;
            }
            return rightChild;
        }
        Node parent = node.parent;
        while(parent != null && (node == parent.rightChild)){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }



    public void print(){
        print(this.root);
    }


    /**
     * 中序遍历
     * @param node
     */
    private void print(Node node){
        if(node != null){
            print(node.leftChild);
            System.out.println(node.val+",");
            print(node.rightChild);
        }
    }

    /**
     * 层次遍历
     */
    public void printLeft(){
        if(this.root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print("节点值："+temp.val+",平衡值:"+calcNodeBalanceValue(temp)+"\n");
            if(temp.leftChild != null){
                queue.add(temp.leftChild);
            }
            if(temp.rightChild != null){
                queue.add(temp.rightChild);
            }
        }
    }
}
