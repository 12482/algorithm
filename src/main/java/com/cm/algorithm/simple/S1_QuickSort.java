package com.cm.algorithm.simple;


import java.util.Arrays;

import static com.cm.algorithm.util.MyUtils.*;

/**
 * 快速排序:
 *
 * @date 2022/3/30 下午3:13
 * @since
 */
public class S1_QuickSort {


    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        // 把数组分成两部分
        process(arr, start, mid);
        process(arr, mid + 1, end);
        // 合并两部分
//        split(arr, start, mid, end);
    }

    private static void split(int[] arr, int start, int end) {
        int compareValue = arr[end];
        int lessIndex = -1;
        int moreIndex = end;
        for (int i = start; i <= end; i++) {
            if (arr[i] > compareValue) {

            } else if (arr[i] < compareValue) {

            } else {

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
            quickSort(arr1);
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
