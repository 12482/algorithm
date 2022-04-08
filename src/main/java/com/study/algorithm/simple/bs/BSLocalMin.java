package com.study.algorithm.simple.bs;

import com.study.algorithm.util.MyUtils;

/**
 * 数组无序,相邻不等,找到一个局部最小值
 *
 * @date 2022/4/8 下午4:24
 * @since
 */
public class BSLocalMin {


    private static int find(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            //这些情况规定为0
            return 0;
        }
        if (arr.length == 2) {
            return arr[0] < arr[1] ? 0 : 1;
        }
        int n = arr.length;
        // 接下两个判断头和尾是否满足局部最小
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        // 头和尾都不是局部最小,那中间肯定存在局部最小,开始二分
        int left = 0;
        int right = n - 1;
        int mid = n / 2;

        while (left <= right) {
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                right = mid ;
                mid = left + (mid - left) / 2;

            } else {
                left = mid ;
                mid = mid + (right - mid) / 2;

            }
        }
        return -1;
    }


    /**
     * 构造相邻不相等的无序数组
     *
     * @param maxLength
     * @param maxValue
     * @return
     */
    private static int[] generateArray(int maxLength, int maxValue) {
        int length = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[length];

        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = 0;
            do {
                value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            } while (i != 0 && cur == value);
            cur = value;
            arr[i] = value;
        }
        return arr;
    }

    /**
     * @param arr
     * @param i
     * @return
     */
    private static boolean isRightAnswer(int[] arr, int i) {
        if (arr == null || arr.length == 0) {
            return i == -1;
        }
        if (arr.length == 1) {
            return i == 0;
        }
        if (arr.length == 2) {
            int pos = arr[0] < arr[1] ? 0 : 1;
            return pos == i;
        }
        int n = arr.length;
        // 接下两个判断头和尾是否满足局部最小
        if (arr[0] < arr[1]) {
            return 0 == i;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1 == i;
        }

        if (i != -1) {
            return arr[i] < arr[i - 1] && arr[i] < arr[i + 1];
        }
        for (int j = 1; j < arr.length - 1; j++) {
            if (arr[j] < arr[j - 1] && arr[j] < arr[j + 1]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int times = 100000;
        int maxSize = 100;
        int maxValue = Integer.MAX_VALUE;


        boolean success = true;
        System.out.println("start ...");
        for (int i = 0; i < times; i++) {
            int[] arr = generateArray(maxSize, maxValue);
//            int[] arr = {1704416243 , 196004914 , 21019638 , -1102564674 , 75641711 , -1121955310 , 353182151 , 1231980313 };
            int pos = find(arr);
            if (!isRightAnswer(arr, pos)) {
                MyUtils.printArray(arr);
                success = false;
                break;
            }
        }
        System.out.println("end ...");
        System.out.println(success ? "success ..." : "fail....");
    }
}
