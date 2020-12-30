package com.cpp288.demo.algorithm.tree;

import java.util.Random;

/**
 * 二叉查找树
 * 在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 *
 * @author chenjian
 * @date 2020/12/29 下午1:52
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 数据插入
     *
     * @param data 插入的数据
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            // 插入值大于当前值
            if (data > p.data) {
                // 如果当前节点右子树为空，则直接插入
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                // 否则继续遍历右侧节点
                p = p.right;
            }
            // 插入值小于当前值
            else {
                // 如果当前节点左子树为空，则直接插入
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                // 否则继续遍历左侧节点
                p = p.left;
            }
        }
    }

    /**
     * 删除节点
     *
     * @param data 删除的数据
     */
    public void delete(int data) {
        // p指向要删除的节点
        Node p = tree;
        // pp记录p的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没有找到数据
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点
            Node minP = p.right;
            // minPP表示minP的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将minP的数据替换到p中
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }
        // 删除的节点是叶子节点或者仅有一个子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 查找节点
     *
     * @param data 查找的数据
     * @return 找到的节点，没有找到返回null
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 查找最小值
     *
     * @return 最小节点
     */
    public Node findMin() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 查找最大值
     *
     * @return 最大节点
     */
    public Node findMax() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 树节点
     */
    public static class Node {

        /**
         * 数据
         */
        private int data;
        /**
         * 左子树
         */
        private Node left;
        /**
         * 右子树
         */
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + (left != null ? left.data : null) +
                    ", right=" + (right != null ? right.data : null) +
                    '}';
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] data = {1, 5, 2, 6, 3, 9, 7, 19, 28, 49};

        for (int i = 0; i < data.length; i++) {
            binarySearchTree.insert(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            Node node = binarySearchTree.find(data[i]);
            if (node != null) {
                System.out.println(node.toString());
            }
        }
    }
}
