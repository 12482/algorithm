package com.study.algorithm.simple.eor;

/**
 * 一堆数中,只有两个数出现了奇数次,其他数都出现了偶数次,找到这两个数
 *
 * @date 2022/4/8 下午5:57
 * @since
 */
public class FindTwoOddTimesNumber {

    public static void num(int[] arr) {

        //异或, 二进制的无进位相加
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //取整数的最后一个1代表的值
        int lastOneNum = eor & (~eor + 1);

        int n1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & lastOneNum) != 0) {
                n1 ^= arr[i];
            }
        }

        int n2 = n1 ^ eor;

        System.err.println(n1 + "   " + n2);

    }

    public static void main(String[] args) {
        int arr[] = {1,2,2, 1, 2, 3, 2, 4};
        num(arr);
    }
}
