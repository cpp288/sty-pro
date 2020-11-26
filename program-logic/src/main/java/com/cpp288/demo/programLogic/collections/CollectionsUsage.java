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

    /**
     * 查找最大最小值
     * 通过迭代器进行比较
     */
    public static void maxOrMin() {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 33, 15, 12, 8, 7, 1));
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list, Collections.reverseOrder()));
    }

    /**
     * 排序、交换位置、翻转
     */
    public static void sortSwapReverse() {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 33, 15, 12, 8, 7, 1));
        // 排序：内部是用过Arrays.sort实现的
        // 先将List元素复制到一个数组中，然后使用Arrays.sort，排序后，再复制回List
        Collections.sort(list);
        System.out.println(list);
        // 交换位置
        Collections.swap(list, 1, 3);
        System.out.println(list);
        // 翻转：实现思路就是将第一个和最后一个交换，第二个和倒数第二个交换，以此类推，直到中间两个元素交换完毕
        // 如果list实现了RandomAccess接口或列表比较小，根据索引位置，使用上面的swap方法进行交换，否则，由于直接根据索引位置定位元素效率比较低，使用一前一后两个listIterator定位待交换的元素
        Collections.reverse(list);
        System.out.println(list);
    }

    /**
     * 随机化重排
     * 从后往前遍历列表，逐个给每个位置重新赋值，值从前面的未重新赋值的元素中随机挑选。
     * 如果列表实现了RandomAccess接口，或者列表比较小，直接使用前面swap方法进行交换，否则，先将列表内容复制到一个数组中，洗牌，再复制回列表
     */
    public static void shuffle() {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 33, 15, 12, 8, 7, 1));
        Collections.shuffle(list);
        System.out.println(list);
    }

    /**
     * 循环移位
     */
    public static void rotate() {
        // distance正数右移，负数左移
        List<Integer> list1 = new ArrayList<>(Arrays.asList(8, 5, 3, 6, 2));
        Collections.rotate(list1, 2);
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 5, 3, 6, 2));
        Collections.rotate(list2, -2);
        System.out.println(list2);
    }

    public static void main(String[] args) {
//        binarySearch();
//        maxOrMin();
//        sortSwapReverse();
//        shuffle();
        rotate();
    }
}
