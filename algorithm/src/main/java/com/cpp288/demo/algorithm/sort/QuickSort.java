package com.cpp288.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 通过分区的方式，也是将一批数据进行分片排序，通过一个pivot将小于的值放在左边，大于的值放在右边
 * 当p >= r时，就已经排好了，它的时间复杂度是O(nlogn)（如果每次分区都是9:1的话，它的时间复杂度就会退化成O(n2)，这个概率比较低）
 * 由于它是原地排序，空间复杂度是O(1)
 *
 * @author chenjian
 * @date 2020/12/26 上午9:53
 */
public class QuickSort {

    public static void main(String[] args) {
        // 第一次：
        int[] array = new int[]{8, 10, 2, 3, 6, 1, 5};
        System.out.println("原始数据：" + Arrays.toString(array));
        quickSortInternally(array, 0, array.length - 1);
        System.out.println("排序后数据：" + Arrays.toString(array));
    }

    /**
     * 快速排序递归
     *
     * @param a 需要排序的数组
     * @param p 起始下标
     * @param r 结束下标
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    /**
     * 获取分区点
     *
     * @param a 需要排序的数组
     * @param p 起始下标
     * @param r 结束下标
     * @return 分区点
     */
    private static int partition(int[] a, int p, int r) {
        // 指向数组最后一个数据
        int pivot = a[r];
        // 分区点
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i + "当前数组：" + Arrays.toString(a));
        return i;
    }
}
