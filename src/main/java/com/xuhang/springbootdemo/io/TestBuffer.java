package com.xuhang.springbootdemo.io;

import java.nio.ByteBuffer;

/**
 * @author xuhang
 * @date 2020/3/24 14:49
 */
public class TestBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(204800);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println(buf.capacity());
        System.out.println(buf.limit());
        System.out.println(buf.position());

        String str = "abcded";
        System.out.println("==================put==========");
        buf.put(str.getBytes());
        System.out.println(buf.capacity());
        System.out.println(buf.limit());
        System.out.println(buf.position());

        buf.flip();
        System.out.println("==================flip==========");
        System.out.println(buf.capacity());
        System.out.println(buf.limit());
        System.out.println(buf.position());

        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes, 0, 5);

        System.out.println(new String(bytes,0,bytes.length));

        System.out.println("==================get==========");
        System.out.println(buf.capacity());
        System.out.println(buf.limit());
        System.out.println(buf.position());

        if (buf.hasRemaining()) {
            System.out.println(buf.remaining());
        }



    }
}
