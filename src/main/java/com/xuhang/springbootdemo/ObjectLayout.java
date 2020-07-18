package com.xuhang.springbootdemo;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author xuhang
 * @date 2020/4/2 17:02
 */
public class ObjectLayout {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("abc def ghj");
        StringBuffer reverse = stringBuffer.reverse();
        System.out.println(reverse);

    }
}
