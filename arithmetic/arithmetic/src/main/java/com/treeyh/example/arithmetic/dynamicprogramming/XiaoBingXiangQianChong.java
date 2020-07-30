package com.treeyh.example.arithmetic.dynamicprogramming;

/**
 * @version 1.0.0
 * @description: 小兵向前冲:N*M 的棋盘，小兵从左下角走到右上角，只能向上或向右走，问有多少种走法？
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-07-30 16:24
 */
public class XiaoBingXiangQianChong {



    private int step(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }

        return step(n,m-1) + step(n-1,m);
    }

}
