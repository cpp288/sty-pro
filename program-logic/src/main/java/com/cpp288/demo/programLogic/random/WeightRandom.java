package com.cpp288.demo.programLogic.random;

import java.util.Arrays;
import java.util.Random;

/**
 * 带权重随机数
 *
 * @author chenjian
 * @date 2020/11/23 下午3:12
 */
public class WeightRandom {

    /**
     * 带权重的数据
     */
    private Pair[] options;
    /**
     * 累计概率
     */
    private double[] cumulativeProbabilities;
    /**
     * 随机对象
     */
    private Random rnd;

    public WeightRandom(Pair[] options) {
        this.options = options;
        this.rnd = new Random();
        prepare();
    }

    private void prepare() {

        int weights = 0;

        for (Pair pair : options) {
            weights += pair.getWeight();
        }
        cumulativeProbabilities = new double[options.length];

        int sum = 0;
        for (int i = 0; i < options.length; i++) {
            sum += options[i].getWeight();
            // 计算每个的累计概率：比如[0.2,0.9,1]
            cumulativeProbabilities[i] = sum / (double) weights;
        }
    }

    public Object nextItem() {
        double randomValue = rnd.nextDouble();
        // binarySearch会返回找到的元素下标，如果找不到返回"-(插入点)-1"
        int index = Arrays.binarySearch(cumulativeProbabilities, randomValue);
        if (index < 0) {
            index = -index - 1;
        }
        return options[index].getItem();
    }

    static class Pair {

        Object item;
        int weight;

        public Pair(Object item, int weight) {
            this.item = item;
            this.weight = weight;
        }

        public Object getItem() {
            return item;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        Pair[] options = new Pair[]{
                new Pair("2元", 2),
                new Pair("1元", 7),
                new Pair("10元", 1)
        };
        WeightRandom weightRandom = new WeightRandom(options);
        for (int i = 0; i < 10; i++) {
            System.out.println(weightRandom.nextItem());
        }
    }
}
