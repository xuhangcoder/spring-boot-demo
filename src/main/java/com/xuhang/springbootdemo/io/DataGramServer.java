package com.xuhang.springbootdemo.io;

import java.lang.String;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @author xuhang
 * @date 2020/3/25 17:30
 */
public class DataGramServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel ssChannel = DatagramChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.bind(new InetSocketAddress(9898));
        Selector selector = Selector.open();
        ssChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey sk = it.next();

                if (sk.isReadable()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    ssChannel.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                }
            }
            it.remove();
        }

    }
}
