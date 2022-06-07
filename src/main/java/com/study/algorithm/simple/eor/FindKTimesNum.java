package com.study.algorithm.simple.eor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.study.algorithm.util.MyUtils.printArray;

/**
 * 一个数出现了k次，其他数都出现了m次，K > 1, k<m, 找到这个出现了k次的数
 */
public class FindKTimesNum {

    private static int find(int[] arr, int m, int k) {
        int[] flag = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                flag[j] = flag[j] + ((arr[i] >> j) & 1);
            }

        }

        int res = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] % m != 0) {
                res += (1 << i);
            }
        }
        return res;
    }


    private static int[] generateArray(int distinctValue, int maxValue, int m, int k) {
        int length = (distinctValue - 1) * m + k;
        int[] arr = new int[length];
        Set<Integer> distinctSet = new HashSet<>();
        int kValue = (int) (Math.random() * maxValue - Math.random() * maxValue);
        for (int i = 0; i < k; i++) {
            arr[i] = kValue;
        }
        distinctSet.add(kValue);
        for (int i = k; i < length;) {
            int rand = 0;
            do {
                rand = (int) (Math.random() * maxValue - Math.random() * maxValue);
            } while (!distinctSet.contains(rand));
            for (int j = 0; j < m; j++, i++) {
                arr[i] = rand;
            }
        }

        //打散
        for (int i = 0; i < arr.length; i++) {
            int rand = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[rand];
            arr[rand] = tmp;
        }

        return arr;
    }

    private static int mapCount(int[] arr, int m, int k) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (valueCount.containsKey(arr[i])) {
                valueCount.put(arr[i], valueCount.get(arr[i]) + 1);
            } else {
                valueCount.put(arr[i], 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() != m) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("no");
    }

    public static void main(String[] args) {
        int runTimes = 50000;
        int distinctValue = 10;
        int maxValue = 100;
//        int m = 12 ;
//        int k = 3;

        System.out.println("start ...");
        for (int i = 0; i < runTimes; i++) {
            int m = (int)(Math.random()*100 )+ 2;
            int k = 1;
            do {
                k = (int)(Math.random()*100 +1);
            }while (k >= m);
            int[] arr = generateArray(distinctValue, maxValue, m, k);
            int r1 = mapCount(arr, m, k);
            int r2 = find(arr, m, k);
            if(r1 != r2){
                System.err.println("error ...");
                printArray(arr);
                System.out.println(m);
                System.out.println(k);
                break;
            }
        }
        System.out.println("end ...");

    }


}
