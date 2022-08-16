package cn.song.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioSocketClient {

    public void start() {

        try (SocketChannel socketChannel = SocketChannel.open()) {

            //连接服务端socket
            SocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
            socketChannel.connect(socketAddress);
            int sendCount = 0;
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //这里最好使用selector处理   这里只是为了写的简单
            while (sendCount < 2) {

                buffer.clear();
                String message ="current time : " + System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < 1024; i++) {
                   stringBuffer.append(message);
                }
                message = stringBuffer.toString();

                //向服务端发送消息
                buffer.put(message.getBytes());

                //读取模式
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();

                //从服务端读取消息
                int readLenth = socketChannel.read(buffer);

                //读取模式
                buffer.flip();

                byte[] bytes = new byte[readLenth];
                buffer.get(bytes);
                System.out.println(new String(bytes, "UTF-8"));
                buffer.clear();
                sendCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


