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
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        bubbleSort(array);
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
