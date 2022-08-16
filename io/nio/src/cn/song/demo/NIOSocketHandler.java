package cn.song.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOSocketHandler {

    //选择器，也成多路复用起
    private Selector selector;
    //服务端通道
    private ServerSocketChannel socketChannel;
    //服务端监听端口
    private int port;
    //编码格式
    private static String localCharset = "UTF-8";
    //设置池子
    private int bufferSize = 1024;

    private ByteBuffer byteBuffer= ByteBuffer.allocate(bufferSize);


    public NIOSocketHandler(int port) {
        this.port = port;
        startServer();
    }

    private void startServer() {

        try {

            //获得选择器
            this.selector = Selector.open();
            //获取服务端通道
            socketChannel = ServerSocketChannel.open();

            //绑定端口并设置非阻塞
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            socketChannel.bind(inetSocketAddress);
            socketChannel.configureBlocking(false);

            //注册通道到选择器
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("============= 服务端启动 ==============");

            while (true) {
                System.out.println("等待连接");
                int select = selector.select();
                System.out.println("获得链接：" + select);

                Iterator<SelectionKey> keysIterator = selector.selectedKeys().iterator();

                while (keysIterator.hasNext()) {
                    SelectionKey thisKey = keysIterator.next();

                    keysIterator.remove();

                    if (!thisKey.isValid()) {
                        continue;
                    }

                    if (thisKey.isAcceptable()) {
                        handleAccept(thisKey);
                    } else if (thisKey.isConnectable()) {
                        System.out.println("isConnectable");
                    } else if (thisKey.isReadable()) {
                        handleRead(thisKey);
                    } else if (thisKey.isWritable()) {
                        handleWrite(thisKey);
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void handleAccept(SelectionKey selectionKey) throws IOException {
        //获取channel
        SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
        //非阻塞
        socketChannel.configureBlocking(false);
        //注册selector
        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        System.out.println("建立请求......");
    }

    public String handleRead(SelectionKey selectionKey) throws IOException {
        String message = null;
        try {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            byteBuffer.clear();
            int flag = socketChannel.read(byteBuffer);
            if (flag == -1) {
                selectionKey.channel().close();
                selectionKey.cancel();
                return null;
                }
            byteBuffer.flip();
            byte[] buf = new byte[byteBuffer.remaining()];
            byteBuffer.get(buf);
            message = new String(buf);
            System.out.println("receive message:" + message);
            byteBuffer.clear();
            selectionKey.interestOps(SelectionKey.OP_WRITE);
            } catch (IOException e) {
            e.printStackTrace();
            }
        return message;
    }

    public void handleWrite(SelectionKey selectionKey) throws IOException {
        try {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            byteBuffer.clear();
            String message = "receive success";
            byteBuffer.put(message.getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            System.out.println("reply:" + message);
            byteBuffer.clear();
            selectionKey.interestOps(SelectionKey.OP_READ);
            } catch (IOException e) {
            e.printStackTrace();
            }
    }
}
