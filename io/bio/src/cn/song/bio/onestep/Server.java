package cn.song.bio.onestep;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("=========server启动=========");
        //1.创建监听ServerSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.获得客户端连接的套接字
        Socket accept = serverSocket.accept();
        //3.获得客户端套接字的字节输入流
        InputStream inputStream = accept.getInputStream();
        //4.通过字节输入流包装成一个缓冲字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //5.获取客户端内容
        String msg = null;
        if ((msg = bufferedReader.readLine()) != null) {
            System.out.println("获得客户端消息：" + msg);
        }
    }


}
