package com.xuhang.springbootdemo.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author xuhang
 * @date 2020/3/24 23:08
 */
public class TestChannel {
    @Test
    public void test2() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("D:\\elastic-apm-agent-0.7.1.jar"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\elastic-apm-agent-0.7.1_bak.jar"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        inChannel.transferTo(0, inChannel.size(), outChannel);

        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    @Test
    public void test() throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("D:\\elastic-apm-agent-0.7.1.jar"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\elastic-apm-agent-0.7.1_bak.jar"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        MappedByteBuffer inBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0,inChannel.size());
        MappedByteBuffer outBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0,inChannel.size());

        byte[] bytes = new byte[inBuf.limit()];
        inBuf.get(bytes);
        outBuf.put(bytes);
        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {
            fis = new FileInputStream("D:\\elastic-apm-agent-0.7.1.jar");
            fos = new FileOutputStream("D:\\elastic-apm-agent-0.7.1-bak.jar");

            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();
            //使用非直接缓存区实现
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (fisChannel.read(buf) != -1) {
                buf.flip();
                fosChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {

        } finally {
            if (fosChannel != null) {

                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fisChannel != null) {

                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
