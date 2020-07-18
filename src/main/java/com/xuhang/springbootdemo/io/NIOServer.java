package com.xuhang.springbootdemo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author xuhang
 * @date 2020/3/25 16:59
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //获取服务端通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //开启非阻塞模式
        ssChannel.configureBlocking(false);
        //绑定端口号
        ssChannel.bind(new InetSocketAddress(9898));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册进选择器
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环选择器
        while (selector.select() > 0) {

            //获取当前选择器中所有已就绪的监听事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey sk = it.next();
                //判断具体是什么事件准备就绪
                if (sk.isAcceptable()) {

                    SocketChannel sChannel = ssChannel.accept();

                    sChannel.configureBlocking(false);

                    sChannel.register(selector, SelectionKey.OP_READ);

                } else if (sk.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) sk.channel();

                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = sChannel.read(buf)) >0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                //取消选择键
                it.remove();
            }

        }
    }
}
