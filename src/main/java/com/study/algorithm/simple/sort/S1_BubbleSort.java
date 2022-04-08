package com.study.algorithm.simple.sort;


import com.study.algorithm.util.MyUtils;

import java.util.Arrays;

/**
 * 冒泡排序:
 * 每次冒泡都会对相邻的两个元素进行比较,看是否满足大小关系,如果不满足就让他两交换,一次冒泡至少会让一个元素移动它应该在的位置,重复n次,就完成了n个数据的排序
 * 优化点:
 * 只要在一次排序过程中没有数据交换,就说明已经是有序的了,可以终止排序
 *
 * @date 2022/3/30 下午3:13
 * @since
 */
public class S1_BubbleSort {


    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;

        for (int i = length - 1; i > 0; i--) {
            boolean exchange = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    MyUtils.swap(arr, j, j + 1);
                    exchange = true;
                }
            }
            if (!exchange) {
                //优化点, 无交换则可直接退出
                break;
            }
        }
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxSize = 100;
        int maxValue = Integer.MAX_VALUE;


        boolean success = true;
        System.out.println("start ...");
        for (int i = 0; i < times; i++) {
            int[] arr = MyUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = MyUtils.copyArray(arr);
            int[] arr2 = MyUtils.copyArray(arr);
            bubbleSort(arr1);
            Arrays.sort(arr2);
            if (!MyUtils.arrayEquals(arr1, arr2)) {
                MyUtils.printArray(arr1);
                MyUtils.printArray(arr2);
                System.out.println("error ...");
                success = false;
                break;
            }
        }
        System.out.println("end ...");
        System.out.println(success ? "success ..." : "fail....");
    }
}
