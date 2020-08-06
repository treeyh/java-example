package com.treeyh.example.designpattern.sinleton;

import sun.plugin2.message.GetAppletMessage;

/**
 * @version 1.0.0
 * @description: 单例，枚举模式
 * @author: Tree
 * @email: tree@ejyi.com
 * @create 2020-08-06 15:42
 */
public class Sinleton01 {

    private Sinleton01(){}

    public static Sinleton01 getInstance(){
        return Sinleton01Enum.SINLETON.getSinleton01();
    }

    private enum Sinleton01Enum {
        SINLETON;

        private Sinleton01 sinleton01;

        Sinleton01Enum(){
            sinleton01 = new Sinleton01();
        }

        public Sinleton01 getSinleton01(){
            return sinleton01;
        }
    }
}
