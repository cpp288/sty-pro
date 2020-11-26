package com.cpp288.demo.programLogic.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections用法以及原理
 *
 * @author chenjian
 * @date 2020/11/26 上午11:32
 */
public class CollectionsUsage {

    /**
     * 二分查找（需要排序，从中间元素开始比较查找）
     * List的二分查找的基本思路与Arrays中的是一样的
     * 数组可以根据索引直接定位任意元素，实现效率很高，但List就不一定了，具体分为两种情况
     * 1. 如果List可以随机访问（如数组），即实现了RandomAccess接口，或者元素个数比较少，则实现思路与Arrays一样，根据索引直接访问中间元素进行比较
     * 2. 否则使用迭代器的方式移动到中间元素进行比较
     * 从效率角度，如果List支持随机访问，效率为O(log2(N))，如果通过迭代器，那么比较的次数为O(log2(N))，但遍历移动的次数为O(N), N为列表长度
     */
    private static void binarySearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(35, 33, 15, 12, 8, 7, 1));
        System.out.println(Collections.binarySearch(list, 7, Collections.reverseOrder()));
    }

    public static void main(String[] args) {
        binarySearch();
    }
}
