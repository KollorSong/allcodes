package cn.song.bio.file;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //1. 注册服务端套接字
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                System.out.println("========== 等待客户端发送文件 ==============");
                //2. 获取客户端套接字
                Socket accept = serverSocket.accept();
                //3. 创建启动线程处理
                new Thread(new FileSaveThread(accept)).start();
            }

        }catch (Exception exception){

        }
    }
}
