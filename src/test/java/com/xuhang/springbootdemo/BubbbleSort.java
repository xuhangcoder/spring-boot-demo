package com.xuhang.springbootdemo;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author xuhang
 * @date 2018/12/3 17:30
 */
public class BubbbleSort {


    public static int[] maopao(int[] source){
        long start = System.currentTimeMillis();

        for (int i = source.length-1; i >0 ; i--) {


            for (int j = 0; j < i; j++) {
                if (source[j] > source[j + 1]) {
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j+1] = temp;

                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为："+(end-start));
        return source;

    }

    public static void main(String[] args) {
        int[] arr = {15,2,4,30,10};
        int[] str = BubbbleSort.maopao(arr);
        for (int num : str) {
            System.out.println(num+"");
        }
    }

}
