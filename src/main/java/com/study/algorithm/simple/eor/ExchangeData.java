package com.study.algorithm.simple.eor;

/**
 * 不申请变量交换两个数
 */
public class ExchangeData {



    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a +"  "+ b);
    }
}
