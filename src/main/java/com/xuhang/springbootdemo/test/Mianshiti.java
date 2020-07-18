package com.xuhang.springbootdemo.test;

import java.util.HashMap;

/**
 * @author xuhang
 * @date 2020/4/24 17:07
 */
public class Mianshiti {

    void f(String  s) {
        System.out.println("调用了 String的参数");

    }
    void f(Integer i) {
        System.out.println("调用了 Integer的参数");

    }
    void g(double  s) {
        System.out.println("调用了 double的参数");

    }
    void g(Integer i) {
        System.out.println("调用了 Integer的参数");

    }

    <String,T,ChildClass> String get(String string, T t) { return string; }

    public static void main(String[] args) {
        float a = 0.125f; double b = 0.125d; System.out.println((a - b) == 0.0); //true
        double c = 0.8; double d = 0.7; double e = 0.6;
        System.out.println((c-d)==(d-e));//false

        System.out.println(1.0 / 0); //Infinity

        System.out.println(0.0 / 0.0);//NaN

        //new Mianshiti().f(null); 编译报错
        new Mianshiti().g(1);//调用double

        String str = null;
        switch (str) {//抛出异常
            case "null" : System.out.println("调用了1"); break;
//            case null : System.out.println("调用了2");break;
            default:
                System.out.println("什么也没匹配到");
        }

        HashMap<Object, Object> map = new HashMap<>(10000);
        for (int i = 0; i < 10000; i++) {
            map.put("abc", "abc");
        }
    }
}
