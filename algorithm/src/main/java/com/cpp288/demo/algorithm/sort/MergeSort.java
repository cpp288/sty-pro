package com.cpp288.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 1. 稳定排序
 * 2. 时间复杂度：O(nlogn)
 * 3. 空间复杂度：由于需要开辟临时空间，不是原地排序，空间复杂度是O(n)
 *
 * @author chenjian
 * @date 2020/12/25 上午11:49
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        mergeSortInternally(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序递归
     *
     * @param a 需要排序的数组
     * @param p 起始下标
     * @param r 结束下标
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
//        merge(a, p, q, r);
        mergeBySentry(a, p, q, r);
    }

    /**
     * 将a[p...q]和a[q+1...r]合并为a[p...r]
     *
     * @param a 需要排序的数组
     * @param p 起始下标
     * @param q 中间下标
     * @param r 结束下标
     */
    private static void merge(int[] a, int p, int q, int r) {
        // 初始化变量i, j, k
        int i = p;
        int j = q + 1;
        int k = 0;
        // 申请一个大小跟a[p...r]一样的临时数组
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }

    /**
     * 合并(哨兵)
     *
     * @param a 需要排序的数组
     * @param p 起始下标
     * @param q 中间下标
     * @param r 结束下标
     */
    private static void mergeBySentry(int[] a, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = a[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = a[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
        }
    }
}
