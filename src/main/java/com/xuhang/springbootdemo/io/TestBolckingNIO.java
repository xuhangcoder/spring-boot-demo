package com.xuhang.springbootdemo.io;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author xuhang
 * @date 2020/3/25 11:02
 */
public class TestBolckingNIO {
    @Test
    public void cliet() throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("D:/info.txt"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();

        }

        socketChannel.shutdownOutput();

        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();

        }



        inChannel.close();
        socketChannel.close();

    }
    @Test
    public void  server() throws IOException {
        //获取服务端通道
        ServerSocketChannel sChannel = ServerSocketChannel.open();

        //获取一个文件输出通道
        FileChannel outChannel = FileChannel.open(Paths.get("D:/info-bak.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //绑定端口号
        sChannel.bind(new InetSocketAddress(9898));

        //获取客户端连接的通道
        SocketChannel socketChannel = sChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);


        //接收客户端的数据，并保存到本地

        while (socketChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();

        }

        buf.put("数据接收成功".getBytes());
        buf.flip();
        socketChannel.write(buf);

        socketChannel.close();
        outChannel.close();
        sChannel.close();

    }
}
