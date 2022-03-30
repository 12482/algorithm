package com.cm.algorithm.simple;


import java.util.Arrays;

import static com.cm.algorithm.util.MyUtils.*;

/**
 * 归并排序:
 *  归并排序采用分治思想,把一个数组从中间分为前后两部分,然后对前后两部分分别排序,再将排序好的两部分合并在一起
 * @date 2022/3/30 下午3:13
 * @since
 */
public class S1_MergeSort {


    private static void mergeSort(int[] arr) {
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
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int start1 = start;
        int start2 = mid + 1;
        int[] newArr = new int[end - start + 1];
        int index = 0;
        while (start1 <= mid && start2 <= end) {
            if (arr[start1] <= arr[start2]) {
                newArr[index++] = arr[start1];
                start1++;
            } else {
                newArr[index++] = arr[start2];
                start2++;
            }
        }
        while (start1 <= mid) {
            newArr[index++] = arr[start1++];
        }
        while (start2 <= end) {
            newArr[index++] = arr[start2++];
        }
        int i = 0;
        for (int j = start; j <= end; j++) {
            arr[j] = newArr[i++];
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
            mergeSort(arr1);
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
