package com.cm.algorithm.simple.sort;


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

        int[] split = split(arr, start, end);
        printArray(arr);
        process(arr, start, split[0]);
        process(arr, split[1] + 1, end);
    }

    private static int[] split(int[] arr, int start, int end) {
        int compareValue = arr[end];
        int lessIndex = start-1;
        int moreIndex = end;
        for (int i = start; i < moreIndex; i++) {
            if (arr[i] > compareValue) {
                swap(arr, i,moreIndex -1 );
                moreIndex --;
                i--;
            } else if (arr[i] < compareValue) {
                swap(arr, i,lessIndex+1);
                lessIndex ++;
            }

        }
        swap(arr, end,moreIndex);
        return new int[]{lessIndex,moreIndex};
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxSize = 50;
        int maxValue = 10;

//        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arr = new int[]{ 6 , 9 , 10 , 9 , 9 , 8 };
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
