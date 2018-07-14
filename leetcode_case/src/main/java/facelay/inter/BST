package facelay.inter;


import facelay.base.LinkedListQueue;

import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize(int size) {
        return size;
    }

    //向二分搜索树中添加新的元素
    public void add(E e) {
        root = add(this.root, e);
    }

    //向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    //查看二分搜索树种是否存在元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的非递归前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树。递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 二分搜索树以node为根的中序遍历，递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 二分搜索树以node为根的后序遍历，递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历
    public void levelOrder() throws IllegalAccessException {
        Queue q = new LinkedListQueue();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node cur = (Node) q.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.enqueue(cur.left);
            }
            if (cur.right != null) {
                q.enqueue(cur.right);
            }
        }
    }

    //找到二分搜索树的最小值
    public E miniE() throws IllegalAccessException {
        if (size == 0) {
            throw new IllegalAccessException("BST is empty!");
        }
        return miniE(root).e;
    }

    private Node miniE(Node node) {
        if (node.left == null) {
            return node;
        }
        return miniE(node.left);
    }

    //找到二分搜索树的最大值
    public E maxE() throws IllegalAccessException {
        if (size == 0) {
            throw new IllegalAccessException("BST is empty!");
        }
        return maxE(root).e;
    }

    private Node maxE(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxE(node.right);
    }

    //删除二分搜索树中的最小元素
    public E removeMiniE() throws IllegalAccessException {
        E e = miniE();
        root = removeMiniE(root);
        return e;
    }

    private Node removeMiniE(Node node) {
        if (node.left == null) {
            Node rightNode = this.removeEAndLeftNull(node);
            return rightNode;
        }
        node.left = removeMiniE(node.left);
        return node;
    }

    //删除二分搜索树中的最大元素
    public E removeMaxE() throws IllegalAccessException {
        E e = maxE();
        root = removeMaxE(root);
        return e;
    }

    private Node removeMaxE(Node node) {
        if (node.right == null) {
            Node leftNode = removeEAndRightNull(node);
            return leftNode;
        }
        node.right = removeMaxE(node.right);
        return node;
    }


    //删除该节点左子树为空的情况
    private Node removeEAndLeftNull(Node node) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
    }

    //删除该节点右子树为空的情况
    private Node removeEAndRightNull(Node node) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
    }

    //删除二分搜索树中的任意一个元素e,并返回新的根
    public void removeE(E e) {
        root = removeE(root, e);
    }

    private Node removeE(Node node, E e) {
        if (node == null) {
            return null;
        }

        //在左子树边
        if (e.compareTo(node.e) < 0) {
            node.left = removeE(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {  //在右子树边
            node.right = removeE(node.right, e);
            return node;
        } else {   // e == node.e

            //待删除的节点的右子树为空的情况
            if (node.right == null) {
                Node leftNode = removeEAndRightNull(node);
                return leftNode;
            }

            //待删除的节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = removeEAndLeftNull(node);
                return rightNode;
            }

            /**
             * 待删除节点左右子树均不为空的情况
             * 找到比待删除节点大的最小节点，即该节点的右子树的最小节点
             * 用着节点代替删除的节点，这种方法称为  “后继”  successor
             *
             * 找到比待删除节点小的最大节点，即该节点的左子树的最大节点
             * 用此节点代替删除的节点，这种方法称为  “前驱”  precursor
             */
//            Node successor = miniE(node.right);  //找到该节点
//            successor.right = removeMiniE(node.right);
//            successor.left = node.left;

            Node presursor = maxE(node.left);
            presursor.left = removeMaxE(node.left);
            presursor.right = node.right;

            node.left = node.right = null;
            return presursor;

        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }


    private String generateDepthString(int depth) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
