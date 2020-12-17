package com.cpp288.demo.algorithm.stack;

/**
 * 基于链表实现的栈
 *
 * @author chenjian
 * @date 2020/12/17 上午8:45
 */
public class StackBasedOnLinkedList<T> {

    private Node<T> top = null;

    /**
     * 入栈
     * @param value data
     */
    public void push(T value) {
        final Node<T> newNode = new Node<>(value, null);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    /**
     * 出栈
     * @return data
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        final T data = top.data;
        top = top.next;
        return data;
    }

    public void printAll() {
        Node<T> p = top;
        while (p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList<Integer> stack = new StackBasedOnLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printAll();
        stack.pop();
        stack.printAll();
        stack.pop();
        stack.printAll();
        stack.pop();
        stack.printAll();
    }
}
