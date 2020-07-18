package com.xuhang.springbootdemo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author xuhang
 * @date 2020/3/25 16:58
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {

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
}
