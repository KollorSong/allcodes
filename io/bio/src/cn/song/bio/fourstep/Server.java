package cn.song.bio.fourstep;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //1. 注册服务端套接字
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("========服务器启动========");
            //创建线程池
            SocketThreadPool socketThreadPool = new SocketThreadPool(5, 10);
            //2. 自旋获取客户端套接字
            while (true){
                System.out.println("==========等待连接===========");
                //获取客户端通信套接字
                Socket accept = serverSocket.accept();
                //创建线程任务
                TaskRun taskRun = new TaskRun(accept);
                //线程池执行线程任务
                socketThreadPool.excute(taskRun);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
