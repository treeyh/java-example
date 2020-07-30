package com.treeyh.example.arithmetic.leetcode.dynamicprogramming;


import sun.security.util.Length;

/**
 * https://leetcode-cn.com/problems/house-robber
 */
public class LeetCode198 {

    private int[] result;

    public int solve(int idx, int[] nums) {
        if (idx < 0) {
            return 0;
        }

        if( result[idx] >= 0 ){
            return result[idx];
        }


        result[idx] = Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
        return result[idx];
    }

    public int rob(int[] nums) {
        result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        return solve(nums.length-1, nums);
    }


    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for(int idx = 2; idx < nums.length; ++idx) {
            result[idx] = Math.max(nums[idx] + result[idx - 2], result[idx - 1]);
        }

        return result[nums.length - 1];
    }


    public static void main(String[] args) {
        LeetCode198 lc = new LeetCode198();
        int[] nums = {1,3,3,66,65};
        System.out.println(lc.rob2(nums));
    }


}
