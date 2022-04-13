package com.study.algorithm.simple.tree;

/**
 * 判断一个二叉树是否是平衡搜索二叉树
 *
 * @date 2022/4/2 下午4:25
 * @since
 */
public class BalanceSearchTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static boolean isBalanceSearchTree(TreeNode node) {
        Result result = getResult(node);
        return result.search && result.balance;
    }

    private static Result getResult(TreeNode node) {
        if (node == null) {
            return new Result(true, true, 0, null, null);
        }
        // 左子树是搜索树?
        Result leftResult = getResult(node.left);
        // 右子树是搜索树?
        Result rightResult = getResult(node.right);
        //以node为根节点的树是搜索数?
        boolean greatThanLeft = leftResult.max == null || node.value > leftResult.max;
        boolean lessThanRight = rightResult.min == null || node.value < rightResult.min;
        boolean search = leftResult.search && rightResult.search && greatThanLeft && lessThanRight;

        //取出当前树的最大最小值
        int max = rightResult.max == null ? node.value : rightResult.max;
        int min = rightResult.min == null ? node.value : rightResult.min;

        boolean balance = leftResult.balance && rightResult.balance && Math.abs(leftResult.high - rightResult.high) <= 1;
        int high = Math.max(leftResult.high, rightResult.high) + 1;

        return new Result(search, balance, high, max, min);
    }

    private static class Result {
        boolean search;
        boolean balance;
        int high;
        Integer max;
        Integer min;


        public Result(boolean search, boolean balance, int high, Integer max, Integer min) {
            this.search = search;
            this.balance = balance;
            this.high = high;
            this.max = max;
            this.min = min;
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
//        t1.left = t2;
//        t1.right = t5;
//        t2.left = t3;
//        t2.right = t4;
//        t5.left = t6;
//        t5.right = t7;
//        System.err.println(isBalanceSearchTree(t1));
        t4.left = t2;
        t4.right = t6;
        t2.left = t1;
        t2.right = t3;
        t6.left = t5;
        t6.right = t7;
        System.err.println(isBalanceSearchTree(t4));
    }
}
