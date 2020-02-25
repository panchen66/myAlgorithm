package com.panchen.interviewPreparation;

/**
 * @Description: 红黑树是一种含有红黑结点并能自平衡的二叉查找树。它必须满足下面性质：
 * <p>
 * 性质1：每个节点要么是黑色，要么是红色。 性质2：根节点是黑色。 性质3：每个叶子节点（NIL）是黑色。 性质4：每个红色结点的两个子结点一定都是黑色。
 * 性质5：任意一结点到每个叶子结点的路径都包含数量相同的黑结点。 从性质5又可以推出：
 * <p>
 * 性质5.1：如果一个结点存在黑子结点，那么该结点肯定有两个子结点
 * <p>
 * <p>
 * 跟平衡二叉树的区别 ：
 * <p>
 * AVL树是一棵严格的平衡树，它所有的子树都满足二叉平衡树的定义。因此AVL树高被严格控制，因此AVL树的查找比较高效。但AVL树插入、删除结点后旋转的次数比红黑树多。
 * <p>
 * 红黑树用非严格的平衡来降低插入删除时旋转的次数。
 * <p>
 * 因此，如果你的业务中查找远远多于插入、删除，那选AVL树；  如果查找、插入、删除频率差不多，那么选择红黑树。
 * <p>
 * <p>
 * 将红黑树看成一颗普通的二叉查找树完成插入删除操作，然后，通过旋转以及颜色调整来使得操作后的树满足红黑树的所有特性即可
 * <p>
 * 代码来源 ： https://blog.csdn.net/qq_41854763/article/details/82694873
 * @author: chenp
 * @date: 2020/02/16 14:25
 */
public class RedBlackTree {

    RBTreeNode root;
    private final boolean RED = false;
    private final boolean BLACK = true;


    public RBTreeNode query(int key) {
        RBTreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getKey() == key) {
                return tmp;
            } else if (tmp.getKey() > key) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        return null;
    }

    public void insert(int key) {
        RBTreeNode node = new RBTreeNode(key);
        if (root == null) {
            root = node;
            node.setColor(BLACK);
            return;
        }
        RBTreeNode parent = root;
        RBTreeNode son;
        if (key <= parent.getKey()) {
            son = parent.getLeft();
        } else {
            son = parent.getRight();
        }
        //find the position
        while (son != null) {
            parent = son;
            if (key <= parent.getKey()) {
                son = parent.getLeft();
            } else {
                son = parent.getRight();
            }
        }
        if (key <= parent.getKey()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        node.setParent(parent);

        //fix up
        insertFix(node);
    }

    private void insertFix(RBTreeNode node) {
        RBTreeNode father, grandFather;
        while ((father = node.getParent()) != null && father.getColor() == RED) {
            grandFather = father.getParent();
            if (grandFather.getLeft() == father) {  //F为G左儿子的情况，如之前的分析
                RBTreeNode uncle = grandFather.getRight();
                if (uncle != null && uncle.getColor() == RED) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getRight()) {
                    leftRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                rightRotate(grandFather);
            } else {                               //F为G的右儿子的情况，对称操作
                RBTreeNode uncle = grandFather.getLeft();
                if (uncle != null && uncle.getColor() == RED) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getLeft()) {
                    rightRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                leftRotate(grandFather);
            }
        }
        setBlack(root);
    }

    public void delete(int key) {
        delete(query(key));
    }

    private void delete(RBTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null && node.getRight() != null) {
            RBTreeNode replaceNode = node;
            RBTreeNode tmp = node.getRight();
            while (tmp != null) {
                replaceNode = tmp;
                tmp = tmp.getLeft();
            }
            int t = replaceNode.getKey();
            replaceNode.setKey(node.getKey());
            node.setKey(t);
            delete(replaceNode);
            return;
        }
        RBTreeNode replaceNode = null;
        if (node.getLeft() != null) {
            replaceNode = node.getLeft();
        } else {
            replaceNode = node.getRight();
        }

        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = replaceNode;
            if (replaceNode != null) {
                replaceNode.setParent(null);
            }
        } else {
            if (replaceNode != null) {
                replaceNode.setParent(parent);
            }
            if (parent.getLeft() == node) {
                parent.setLeft(replaceNode);
            } else {
                parent.setRight(replaceNode);
            }
        }
        if (node.getColor() == BLACK) {
            removeFix(parent, replaceNode);
        }

    }

    //多余的颜色在node里
    private void removeFix(RBTreeNode father, RBTreeNode node) {
        while ((node == null || node.getColor() == BLACK) && node != root) {
            if (father.getLeft() == node) {  //S为P的左儿子的情况，如之前的分析
                RBTreeNode brother = father.getRight();
                if (brother != null && brother.getColor() == RED) {
                    setRed(father);
                    setBlack(brother);
                    leftRotate(father);
                    brother = father.getRight();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(
                    brother.getRight()))) {
                    setRed(brother);
                    node = father;
                    father = node.getParent();
                    continue;
                }
                if (isRed(brother.getLeft())) {
                    setBlack(brother.getLeft());
                    setRed(brother);
                    rightRotate(brother);
                    brother = brother.getParent();
                }

                brother.setColor(father.getColor());
                setBlack(father);
                setBlack(brother.getRight());
                leftRotate(father);
                node = root;//跳出循环
            } else {                         //S为P的右儿子的情况，对称操作
                RBTreeNode brother = father.getLeft();
                if (brother != null && brother.getColor() == RED) {
                    setRed(father);
                    setBlack(brother);
                    rightRotate(father);
                    brother = father.getLeft();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(
                    brother.getRight()))) {
                    setRed(brother);
                    node = father;
                    father = node.getParent();
                    continue;
                }
                if (isRed(brother.getRight())) {
                    setBlack(brother.getRight());
                    setRed(brother);
                    leftRotate(brother);
                    brother = brother.getParent();
                }

                brother.setColor(father.getColor());
                setBlack(father);
                setBlack(brother.getLeft());
                rightRotate(father);
                node = root;//跳出循环
            }
        }

        if (node != null) {
            node.setColor(BLACK);
        }
    }

    private boolean isBlack(RBTreeNode node) {
        if (node == null) {
            return true;
        }
        return node.getColor() == BLACK;
    }

    private boolean isRed(RBTreeNode node) {
        if (node == null) {
            return false;
        }
        return node.getColor() == RED;
    }

    private void leftRotate(RBTreeNode node) {
        RBTreeNode right = node.getRight();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = right;
            right.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    private void rightRotate(RBTreeNode node) {
        RBTreeNode left = node.getLeft();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = left;
            left.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    private void setBlack(RBTreeNode node) {
        node.setColor(BLACK);
    }

    private void setRed(RBTreeNode node) {
        node.setColor(RED);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(RBTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node);
        inOrder(node.getRight());
    }


    public class RBTreeNode {

        private final boolean RED = false;
        private final boolean BLACK = true;
        private int key;
        private boolean color;
        private RBTreeNode left;
        private RBTreeNode right;
        private RBTreeNode parent;

        public RBTreeNode(int key) {
            this.key = key;
            this.color = RED;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public boolean getColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public RBTreeNode getLeft() {
            return left;
        }

        public void setLeft(RBTreeNode left) {
            this.left = left;
        }

        public RBTreeNode getRight() {
            return right;
        }

        public void setRight(RBTreeNode right) {
            this.right = right;
        }

        public RBTreeNode getParent() {
            return parent;
        }

        public void setParent(RBTreeNode parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "RBTreeNode{" +
                ",key=" + key +
                ", color=" + color +
                '}';
        }
    }


}
