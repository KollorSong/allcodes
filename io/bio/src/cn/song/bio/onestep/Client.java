package cn.song.bio.onestep;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //1. 创建目标服务器Socket
        Socket socket = new Socket("127.0.0.1", 9999);
        //2. 获得对服务端输出流
        OutputStream outputStream = socket.getOutputStream();
        //3. 封装获得打印流
        PrintWriter printWriter = new PrintWriter(outputStream);
        //4. 通过打印流对服务端发送消息
        printWriter.println("hello server!");
        printWriter.flush();



    }
}
