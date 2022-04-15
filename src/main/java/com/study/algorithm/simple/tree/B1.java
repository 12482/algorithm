package com.study.algorithm.simple.tree;

import com.study.algorithm.simple.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的遍历,先序/中序/后序
 * @date 2022/4/15 下午5:22
 * @since
 */
public class B1 {


    /**
     * 先序
     * @param node
     * @param result
     */
    public static  void first(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }
        result.add(node.value);
        first(node.left, result);
        first(node.right, result);


    }

    /**
     * 中序
     * @param node
     * @param result
     */
    public static  void middle(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }
        middle(node.left, result);
        result.add(node.value);
        middle(node.right, result);
    }


    /**
     * 后序
     * @param node
     * @param result
     */
    public static  void last(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }
        last(node.left, result);
        last(node.right, result);
        result.add(node.value);
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
        List<Integer> result1 = new ArrayList<>();
        first(t4,result1);
        System.err.println(result1);
        List<Integer> result2 = new ArrayList<>();
        middle(t4,result2);
        System.err.println(result2);
        List<Integer> result3 = new ArrayList<>();
        last(t4,result3);
        System.err.println(result3);

    }
}
