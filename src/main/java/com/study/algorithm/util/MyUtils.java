package com.study.algorithm.util;


/**
 * @date 2022/3/30 下午3:42
 * @since
 */
public class MyUtils {

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int t : arr) {
            System.out.print(t + " , ");
        }
        System.out.println();
    }

    /**
     * 将数组arr的m位置和n位置的元素交换
     *
     * @param arr
     * @param m
     * @param n
     */
    public static void swap(int[] arr, int m, int n) {
        if (m == n) {
            return;
        }
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }


    /**
     * 随机生成一个指定长度和最大值的正整数数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(long maxSize, long maxValue) {

        int size = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            // - 生成负数
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }


    /**
     * 构造升序数组
     *
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] generateAscArray(int maxLength, int maxValue) {
        int length = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[length];

        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = 0;
            do {
                value = cur + (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            } while (i != 0 && cur > value);
            cur = value;
            arr[i] = value;
        }
        return arr;
    }

    /**
     * 拷贝数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, newArr.length);
        return newArr;
    }

    /**
     * 判断数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean arrayEquals(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null) {
            return false;
        }
        if (arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        if (arr1.length == 0) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
