package com.cpp288.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 简单排序：冒泡排序、插入排序、选择排序
 *
 * @author chenjian
 * @date 2020/12/22 上午9:09
 */
public class SimpleSorts {

    /**
     * 冒泡排序
     *
     * @param a 需要排序的数组
     */
    public static void bubbleSort(int[] a) {
        final int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 提前退出标识位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前元素大于后一个元素，则进行位置交换
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示当前冒泡有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     *
     * @param a 需要排序的数组
     */
    public static void bubbleSort2(int[] a) {
        final int n = a.length;
        if (n <= 1) {
            return;
        }

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) {
                // 没有数据交换，提前退出
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a 需要排序的数组
     */
    public static void insertionSort(int[] a) {
        final int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 插入排序只需要一个赋值操作，
                // 虽然和冒泡、选择排序的时间复杂度一样，但是其他两种的赋值操作比较多，故插入排序性能更好
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     * @param a 需要排序的数组
     */
    public static void selectionSort(int[] a) {
        final int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        bubbleSort(array);
//        insertionSort(array);
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
