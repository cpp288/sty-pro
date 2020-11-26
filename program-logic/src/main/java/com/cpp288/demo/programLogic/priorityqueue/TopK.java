package com.cpp288.demo.programLogic.priorityqueue;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * 求前K个最大的元素
 * 使用最小堆维护这K个元素，最小堆中，根即第一个元素永远都是最小的，新来的元素与根比就可以了
 * 如果小于根，则堆不需要变化，否则用新元素替换根，然后向下调整堆即可
 * 调整的效率为O(log2(K))，这样，总体的效率就是O(N×log2(K))，这个效率非常高，而且存储成本也很低
 *
 * @author chenjian
 * @date 2020/11/25 下午8:53
 */
public class TopK<E> {

    /**
     * 优先级队列
     */
    private PriorityQueue<E> p;
    /**
     * 队列的最大长度
     */
    private int k;

    public TopK(int k) {
        this.k = k;
        this.p = new PriorityQueue<>(k);
    }

    public void addAll(Collection<? extends E> c) {

        for (E e : c) {
            add(e);
        }
    }

    public void add(E e) {
        if (p.size() < k) {
            p.add(e);
            return;
        }
        Comparable<? super E> head = (Comparable<? super E>) p.peek();
        if (head.compareTo(e) > 0) {
            // 小于TopK中的最小值，不用变
            return;
        }
        // 新元素替换原来的最小值成为TopK之一
        p.poll();
        p.add(e);
    }

    public <T> T[] toArray(T[] a) {
        return p.toArray(a);
    }

    public E getKth() {
        return p.peek();
    }

    public static void main(String[] args) {
        TopK<Integer> top5 = new TopK<>(5);
        top5.addAll(Arrays.asList(100, 1, 2, 5, 6, 2, 4, 637, 42, 231, 324, 32121, 565, 32, 22, 123, 55677, 54, 3, 22));
        System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
        System.out.println(top5.getKth());
    }
}
