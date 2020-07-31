package com.treeyh.example.arithmetic.dynamicprogramming;

import com.treeyh.example.arithmetic.utils.JsonUtils;

/**
 * @version 1.0.0
 * @description: 0-1背包问题:给定 n 种物品和一背包。物品 i 的重量似乎 wi，其价值为 vi，背包的容量为 w。问应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-07-30 19:04
 */
public class Bag01 {


    private int[][] result;

    /**
     *
     * @param idx 物品索引
     * @param S 当前背包重量
     * @param W 背包容量
     * @param wis 物品重量数组
     * @param vis 物品价值数组
     * @return 背包中物品价值
     */
    public int search(int idx, int S, int W, int[] wis, int[] vis) {
        if (idx >= wis.length) {
            return 0;
        }

        if (S + wis[idx] > W) {
            return 0;
        }

        if (result[idx][S] >= 0) {
            return result[idx][S];
        }

        result[idx][S] = Math.max(search(idx + 1, S + wis[idx], W, wis, vis) + vis[idx], search(idx+1, S, W, wis, vis));

        return result[idx][S];
    }


    public int search2(int W, int[] wis, int[] vis) {
        for(int i=1; i<=W; ++i) {
            result[0][i] = Integer.MIN_VALUE;
        }

        for (int idx = 1; idx<wis.length; idx++) {
            result[idx][0] = Integer.MIN_VALUE;

            for (int j= 1; j<=W ; j++) {
                result[idx][j] = result[idx-1][j];

                if (j>=wis[idx]) {
                    result[idx][j] = Math.max(result[idx -1][j-wis[idx]] + vis[idx], result[idx][j]);
                }
            }
        }

        return result[wis.length - 1][W];
    }



    public static void main(String[] args) {

//        int[] wis = {11,12,31,41,15,26,37,28,19};
//        int[] vis = {10,21,13,82,15,36,47,28,39};


        int[] wis = {1,2,3,4,5,6,7,8,9};
        int[] vis = {1,2,3,4,5,6,7,8,9};

        int W = 100;
        W = 12;
        Bag01 bag01 = new Bag01();
        bag01.result = new int[vis.length][W+1];

        for (int i = 0; i < bag01.result.length; i ++) {
            for (int j = 0; j<= W; j++) {
                bag01.result[i][j] = -1;
            }
        }

        int value = bag01.search(1, 0, W, wis, vis);
        System.out.println(value);

        System.out.println(JsonUtils.toJson(bag01.result));

//        int value = bag01.search2( W, wis, vis);
//        System.out.println(value);
    }

}
