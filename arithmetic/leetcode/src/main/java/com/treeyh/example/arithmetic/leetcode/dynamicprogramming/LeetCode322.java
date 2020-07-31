package com.treeyh.example.arithmetic.leetcode.dynamicprogramming;

/**
 * @version 1.0.0
 * @description: 零钱兑换 https://leetcode-cn.com/problems/coin-change/，还有问题
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-07-30 20:42
 */
public class LeetCode322 {

    public static int maxValue = 100000000;

    public int coinChangeStat(int idx, int[] coins, int amount) {

        if (amount < 0) {
            return maxValue;
        }
        if (amount == 0) {
            return 0;
        }

        if (idx >= coins.length) {
             return maxValue;
        }

        int a = coinChangeStat(idx, coins, amount - coins[idx]) + 1;
        int b = coinChangeStat(idx +1 , coins, amount);
        return Math.min(a, b);


    }

    public int coinChange(int[] coins, int amount) {

        int res = coinChangeStat(0, coins, amount);
        if (res < maxValue) {
            return res;
        }
        return  -1;

    }

    public static void main(String[] args) {

        int[] coins = {1,2,5};

        LeetCode322 leetCode322 = new LeetCode322();
        int x = leetCode322.coinChange(coins, 11);
        System.out.println(x);
    }
}
