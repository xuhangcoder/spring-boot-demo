package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2019/6/10 17:28
 */
public class Sanjiaoxing {
    public static void main(String[] args) {
        //外循环控制行数
        for (int i = 1; i <= 5; i++) {
            //内循环控制列数
            for (int j = 5; j >0 ; j--) {
                if(j<=i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
