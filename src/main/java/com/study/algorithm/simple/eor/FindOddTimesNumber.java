package com.study.algorithm.simple.eor;

/**
 *
 * 一堆数中,只有一个数出现了奇数次,其他数都出现了偶数次,找到这个数
 * @date 2022/4/8 下午5:57
 * @since
 */
public class FindOddTimesNumber {

    public static int num(int[] arr){

        if(arr == null || arr.length == 0 ){
            throw new IllegalArgumentException("数组不能为空");
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,2,3,2};
        System.out.println(num(arr));
    }
}
