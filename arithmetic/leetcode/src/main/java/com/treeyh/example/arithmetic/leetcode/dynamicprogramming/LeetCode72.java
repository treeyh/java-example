package com.treeyh.example.arithmetic.leetcode.dynamicprogramming;

import com.treeyh.example.arithmetic.leetcode.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0
 * @description: 编辑距离 https://leetcode-cn.com/problems/edit-distance/
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-07-31 10:40
 */
public class LeetCode72 {

    int[][] f;

//    public int search(int i, int j, List<String> word1, List<String> word2) {
//        if(i<0 || j<0){
//            return Math.max(i, j) + 1;
//        }
//        int ii = i +1;
//        int jj = j +1;
//        if(f[ii][jj] < 99999990) {
//            return f[ii][jj];
//        }
//
//        if (word1.get(i).equals(word2.get(j))) {
//            f[ii][jj] = search(i -1, j -1, word1, word2);
//            return f[ii][jj] ;
//        }
//
//        String tmp1 = word1.get(i);
//
//        int insert = search(i, j - 1, word1, word2) + 1;
//        int delete = search(i - 1, j, word1, word2) + 1;
//        int edit = search(i - 1, j - 1, word1, word2) + 1;
//
//
////        return Math.min(res, Math.min(insert, Math.min(delete, edit)));
//        f[ii][jj] = Math.min(insert, Math.min(delete, edit));
//        return f[ii][jj] ;
//    }
//
//
//
//    public int minDistance(String word1, String word2) {
//
//        List<String> words1 = new ArrayList<String>(Arrays.asList(word1.split("")));
//        List<String> words2 = new ArrayList<String>(Arrays.asList(word2.split("")));
//
//        f = new int[word1.length() + 1][word2.length() + 1];
//
//        for(int i= 0; i< word1.length(); i++) {
//            for (int j = 0; j<word2.length(); j++) {
//                f[i][j] = 99999999;
//            }
//        }
//
//        for(int i= 0; i<= word1.length(); i++) {
//            f[i][0] = i;
//        }
//
//        for(int j= 0; j<= word2.length(); j++) {
//            f[0][j] = j;
//        }
//
//        return search(word1.length()-1 , word2.length() - 1, words1, words2);
//    }


    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }




    public static void main(String[] args) {

        String word1 = "helloa1";
        String word2 = "world";

//        String word1 = "";
//        String word2 = "";


        LeetCode72 lc =  new LeetCode72();
        int res = lc.minDistance(word1, word2);
        System.out.println(res);


    }
}
