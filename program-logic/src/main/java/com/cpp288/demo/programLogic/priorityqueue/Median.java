package com.cpp288.demo.programLogic.priorityqueue;

import java.util.*;

/**
 * 求中值
 * 中值就是排序后中间那个元素的值，如果元素个数为奇数，中值是没有歧义的
 * 但如果是偶数，中值可能有不同的定义，可以为偏小的那个，也可以是偏大的那个，或者两者的平均值，或者任意一个
 * 这里，我们假定任意一个都可以
 *
 * @author chenjian
 * @date 2020/11/25 下午9:15
 */
public class Median<E> {

    /**
     * 最小堆
     */
    private PriorityQueue<E> minP;
    /**
     * 最大堆
     */
    private PriorityQueue<E> maxP;
    /**
     * 当前中值
     */
    private E m;

    public Median() {

        this.minP = new PriorityQueue<>();
        this.maxP = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private int compare(E e, E m) {
        Comparable<? super E> cmpr = (Comparable<? super E>) e;
        return cmpr.compareTo(m);
    }

    public void add(E e) {
        // 第一个元素直接赋值
        if (m == null) {
            m = e;
            return;
        }
        // 小于中值，加入最大堆，反之则加入最小堆
        if (compare(e, m) <= 0) {
            maxP.add(e);
        } else {
            minP.add(e);
        }
        // 最小堆元素个数多，即大于中值的元素多，将m加入到最大堆中，然后将堆小堆中的根移除赋值给m
        if (minP.size() - maxP.size() >= 2) {
            maxP.add(this.m);
            this.m = minP.poll();
        } else if (maxP.size() - minP.size() >= 2) {
            minP.add(this.m);
            this.m = maxP.poll();
        }
    }

    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public E getM() {
        return m;
    }

    public static void main(String[] args) {
        Median<Integer> median = new Median<>();
        List<Integer> list = Arrays.asList(34, 90, 67, 45, 1, 4, 5, 6, 7, 9, 10);
        median.addAll(list);
        System.out.println(median.getM());
    }
}
