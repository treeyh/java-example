package com.treeyh.example.arithmetic.utils;

/**
 * @version 1.0.0
 * @description: 打印工具类
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-07-30 10:21
 */
public class PrintUtils {

    public static void printIntArray(int[] ids, int l, int r){
        for(int i : ids){
            System.out.print(i + ",");
        }
        System.out.print("---"+l + ","+ r);

        System.out.println();
    }
}
