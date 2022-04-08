package com.study.algorithm.simple.bs;

import static com.study.algorithm.util.MyUtils.generateAscArray;
import static com.study.algorithm.util.MyUtils.printArray;

/**
 * 数组有序,找到>=某个值的最左边的位置
 *
 * @date 2022/4/8 下午4:24
 * @since
 */
public class BSMostLeftGT {


    private static int find(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            if (arr[0] >= value) {
                return 0;
            } else {
                return -1;
            }
        }
        int r = arr.length - 1;
        int l = 0;
        int mid = l + ((r - l) >>> 1);
        int index = -1;
        while (l <= r) {
            if (arr[mid] >= value) {
                index = mid;
                r = mid -1;
                mid = l + ((r - l) >>> 1);
            } else {
                l = mid +1;
                mid = l + ((r - l) >>> 1);
            }
        }
        return index;
    }

    /**
     * @param arr   數組
     * @param value 要比較的值
     * @param i 二分查找找到的值
     * @return
     */
    private static boolean isRightAnswer(int[] arr, int value, int i) {
        if (arr == null || arr.length == 0) {
            return i == -1;
        }
        int index = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] >= value) {
                index = j;
                break;
            }
        }
        return index == i;
    }

    public static void main(String[] args) {
        int times = 100000;
        int maxSize = 10;
        int maxValue = 1000;
        boolean success = true;
        System.out.println("start ...");
        for (int i = 0; i < times; i++) {
            int value = (int) (Math.random() * (maxValue + 1));
            int[] arr = generateAscArray(maxSize, maxValue);
//            int value = 489;
//            int[] arr = {-849 , -435 , -59 , 205 , 974};
            int pos = find(arr, value);
//            System.err.println(pos);
            if (!isRightAnswer(arr, value, pos)) {
                printArray(arr);
                System.out.println(value);;
                success = false;
                break;
            }
        }
        System.out.println("end ...");
        System.out.println(success ? "success ..." : "fail....");
    }
}
