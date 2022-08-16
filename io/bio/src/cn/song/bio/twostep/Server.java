package cn.song.bio.twostep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: Server
 * @Author: kollorsong
 * @Description: 实现多收和多发
 * @DateTime: 2022/8/8 - 9:08 PM
 */
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));
        //5.获取客户端内容
        String msg = null;
        while ((msg = bufferedReader.readLine()) != null) {
            System.out.println("获得客户端消息：" + msg);
        }

    }


}
