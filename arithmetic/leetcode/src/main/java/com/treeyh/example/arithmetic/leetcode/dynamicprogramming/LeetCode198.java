package com.treeyh.example.arithmetic.leetcode.dynamicprogramming;


/**
 * https://leetcode-cn.com/problems/house-robber
 */
public class LeetCode198 {

    public int solve(int idx, int[] nums) {
        if (idx < 0) {
            return 0;
        }
        return Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
    }

    public int rob(int[] nums) {
        return solve(nums.length-1, nums);
    }


    public static void main(String[] args) {
        LeetCode198 lc = new LeetCode198();
        int[] nums = {1,2,3,4,65};

        System.out.println(lc.rob(nums));
    }


}
