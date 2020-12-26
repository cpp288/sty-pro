package com.cpp288.demo.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 * 计数排序主要限制：
 * 1. 数据范围不能过大，比如数据是0,1,0,100,1000，这样数据范围是1000，比元素个数5大很多，就不适用
 * 2. 只能给非负整数排序，如果是小数或者是负数则需要处理成正数
 *
 * @author chenjian
 * @date 2020/12/26 下午4:33
 */
public class CountingSort {

    public static void main(String[] args) {
        int size = 1000;
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        countingSort(arr, size);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
     *
     * @param a 数组
     * @param n 数组大小
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 查找数组中数据的范围，查找最大值
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤了，有点难理解，这部分可以查看文章进行理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
