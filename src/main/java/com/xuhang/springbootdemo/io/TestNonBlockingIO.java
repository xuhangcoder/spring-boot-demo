/*
package com.xuhang.springbootdemo.io;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

*/
/**
 * @author xuhang
 * @date 2020/3/25 14:13
 *//*

public class TestNonBlockingIO {
    @Test
    public void client() throws IOException {

        SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        schannel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            buf.put((LocalDateTime.now().toString()+"\n"+str).getBytes());
            buf.flip();
            schannel.write(buf);
            buf.clear();
        }


        schannel.close();


    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        ssChannel.configureBlocking(false);

        ssChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

         ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();

                if (next.isAcceptable()) {
                    SocketChannel socketChannel = ssChannel.accept();

                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);

                } else if (next.isReadable()) {
                    SocketChannel channel = (SocketChannel) next.channel();

                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len = 0;
                    while ((len = channel.read(buf)) != -1) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }

                iterator.remove();
            }

        }


    }
}
*/
