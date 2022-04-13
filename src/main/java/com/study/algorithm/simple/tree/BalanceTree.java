package com.study.algorithm.simple.tree;

/**
 * 判断一个二叉树是否是平衡的
 * @date 2022/4/2 下午4:25
 * @since
 */
public class BalanceTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static boolean isBalance(TreeNode node) {
        Result highAndBalance = getHighAndBalance(node);
        return highAndBalance.balance;
    }

    private static Result getHighAndBalance(TreeNode node) {
        if (node == null) {
            return new Result(true, 0);
        }

        Result leftRes = getHighAndBalance(node.left);
        Result rightRes = getHighAndBalance(node.right);
        int high = Math.max(leftRes.high, rightRes.high) + 1;
        // 左子树是平衡的,右子树也是平衡的,且左右子数高度相差不超过1
        boolean balance = leftRes.balance && rightRes.balance && Math.abs(leftRes.high - rightRes.high) <= 1;
        return new Result(balance, high);
    }

    private static class Result {
        boolean balance;
        int high;

        public Result(boolean balance, int high) {
            this.balance = balance;
            this.high = high;
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t5;
        t2.left=t3;
        t2.right = t4;
        t5.left = t6;
        t5.right = t7;



        System.err.println(isBalance(t1));
    }
}
