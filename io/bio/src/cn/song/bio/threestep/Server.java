package cn.song.bio.threestep;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            //1. 注册服务端套接字
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("============= Server Start ===============");
            //2. 自旋获取与客户端通信套接字
            while (true){
                //3.1 获取套接字，
                Socket accept = serverSocket.accept();
                //3.2 新建线程对象，处理当前生成的客户端套接字
                new SocketServerThread(accept).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
