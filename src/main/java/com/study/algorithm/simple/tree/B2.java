package com.study.algorithm.simple.tree;

import com.study.algorithm.simple.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 已知先序,中序,求树的形状
 *
 * @date 2022/4/15 下午5:22
 * @since
 */
public class B2 {


    private static TreeNode buildTree(int[] first, int[] middle) {

        Map<Integer, Integer> valueAndIndex = new HashMap<>();
        for (int i = 0; i < first.length; i++) {
            valueAndIndex.put(first[i], i);
        }
        return build(valueAndIndex, middle, 0, middle.length - 1);
    }

    private static TreeNode build(Map<Integer, Integer> valueAndIndex, int[] middle, int mStart, int mEnd) {


        if (mStart > mEnd) {
            return null;
        }

        Integer minIndex = null;
        int headInMiddle = -1;
        for (int i = mStart; i <= mEnd; i++) {
            Integer index = valueAndIndex.get(middle[i]);
            if (minIndex == null || index < minIndex) {
                minIndex = index;
                headInMiddle = i;
            }
        }
        TreeNode rootNode = new TreeNode(middle[headInMiddle]);
        rootNode.left = build(valueAndIndex, middle, mStart, headInMiddle - 1);
        rootNode.right = build(valueAndIndex, middle, headInMiddle + 1, mEnd);
        return rootNode;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t4.left = t2;
        t4.right = t6;
        t2.left = t1;
        t2.right = t3;
        t6.left = t5;
        t6.right = t7;

        int[] first = new int[]{4, 2, 1, 3, 6, 5, 7};
        int[] middle = new int[]{1, 2, 3, 4, 5, 6, 7};

        TreeNode treeNode = buildTree(first, middle);

        List<Integer> firstResult = new ArrayList<>();
        B1.first(treeNode,firstResult);

        List<Integer> middleResult = new ArrayList<>();
        B1.middle(treeNode,middleResult);

        List<Integer> lastResult = new ArrayList<>();
        B1.last(treeNode,lastResult);

        System.err.println(firstResult);
        System.err.println(middleResult);
        System.err.println(lastResult);
    }
}
