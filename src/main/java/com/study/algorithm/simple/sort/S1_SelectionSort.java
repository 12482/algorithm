package com.study.algorithm.simple.sort;


import com.study.algorithm.util.MyUtils;

import java.util.Arrays;

/**
 * 选择排序:
 * 将数组分成左右两部分,左边是有序的,左边初始位置为0,右边是无序的,每次选择右边最小的数放到左边的,直到右边没有数据
 *
 * @date 2022/3/30 下午3:13
 * @since
 */
public class S1_SelectionSort {


    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;

        for (int i = 0; i < length; i++) {

            int minIndex = i;
            for(int j = i ; j < length ; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            MyUtils.swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxSize = 1000;
        int maxValue = Integer.MAX_VALUE;


        boolean success = true;
        System.out.println("start ...");
        for (int i = 0; i < times; i++) {
            int[] arr = MyUtils.generateRandomArray(maxSize, maxValue);
            int[] arr1 = MyUtils.copyArray(arr);
            int[] arr2 = MyUtils.copyArray(arr);
            selectionSort(arr1);
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
