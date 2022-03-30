package com.cm.algorithm.simple;


import java.util.Arrays;

import static com.cm.algorithm.util.MyUtils.*;

/**
 * 插入排序:
 * 将数组分成左右两部分,左边是有序的,左边初始位置为0,右边是无序的,每次选择右边的第一个数插入到左边合适的位置,左边界右移,循环执行直到所有数据都在左边
 *
 * @date 2022/3/30 下午3:13
 * @since
 */
public class S1_InsertionSort {


    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            int value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                    arr[j] = value;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxSize = 1000;
        int maxValue = Integer.MAX_VALUE;

        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arr1 = copyArray(arr);
        int[] arr2 = copyArray(arr);
        boolean success = true;
        System.out.println("start ...");
        for (int i = 0; i < times; i++) {
            insertionSort(arr1);
            Arrays.sort(arr2);
            if (!arrayEquals(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                System.out.println("error ...");
                success = false;
                break;
            }
        }
        System.out.println("end ...");
        System.out.println(success ? "success ..." : "fail....");
    }
}
