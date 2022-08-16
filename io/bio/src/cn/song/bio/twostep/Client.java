package cn.song.bio.twostep;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //1. 创建目标服务器Socket
        Socket socket = new Socket("127.0.0.1", 9999);
        //2. 获得对服务端输出流
        OutputStream outputStream = socket.getOutputStream();
        //3. 封装获得打印流
        PrintStream printStream = new PrintStream(outputStream);

        Scanner scanner = new Scanner(System.in);
        //4. 通过打印流对服务端发送消息
        while (true){
            System.out.print("请说：");
            String mes = scanner.nextLine();
            System.out.println("mes:"+mes);
            printStream.println(mes);
            printStream.flush();
        }

    }
}
