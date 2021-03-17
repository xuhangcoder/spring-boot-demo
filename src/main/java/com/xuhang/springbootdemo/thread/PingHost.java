package com.xuhang.springbootdemo.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author：xuhang
 * @description：
 * @date：2018/10/31 15:07
 */
public class PingHost {

    public static boolean checkHost(String ip) throws IOException {
        long begin = System.currentTimeMillis();
        Process pro = Runtime.getRuntime().exec("ping " + ip);
        //判断返回信息是否包含TTL关键字
        String line;
        BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));

        while ((line = buf.readLine()) != null) {
            if (line.contains("TTL")) {
                long end1 = System.currentTimeMillis();
                long l1 = end1 - begin;
                System.out.println("主机" + ip + "可到达  耗费时间："+l1+"ms" );
               
                return true;
            }
        }
        long end2 = System.currentTimeMillis();
        long l2 = end2 - begin;
        System.out.println("主机" + ip + "不可到达  耗费时间："+l2+"ms");
        return false;

    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        PingHost ph = new PingHost();
//        for (int i = 147; i < 300; i++) {
//            ph.checkHost("10.40.96." + i);
//        }
        //测试Thread方式
//        for (int i = 147; i < 300; i++) {
//            MultiThreadByThread btt =new MultiThreadByThread("10.40.96." + i);
//            btt.start();

        //测试runnable方式
        for (int i =0; i < 300; i++) {
            MultiThreadByRunnable mtb =new MultiThreadByRunnable("172.16.10." + i);
            new Thread(mtb).start();

        }
    }
}
