package com.xuhang.springbootdemo.RedisTest;

/**
 * @author xuhang
 * @date 2019/2/25 15:47
 */
public class MoveDemo {

    public static MoveDemo t1 = new MoveDemo();
    public static MoveDemo t2 = new MoveDemo();
    {
        System.out.println("构造块");

    }
    static {
        System.out.println("静态块");

    }

    public static void main(String[] args) {
        MoveDemo moveDemo = new MoveDemo();
    }
}
