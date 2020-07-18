package com.xuhang.springbootdemo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author xuhang
 * @date 2020/3/25 17:26
 */
public class DateGramChannelClient {
    public static void main(String[] args) throws IOException {

        DatagramChannel sChannle = DatagramChannel.open();
        sChannle.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            buffer.put((LocalDateTime.now() + "\n" + next).getBytes());
            buffer.flip();
            sChannle.send(buffer, new InetSocketAddress("127.0.0.1", 9898));
            buffer.clear();
        }

        sChannle.close();
    }
}
