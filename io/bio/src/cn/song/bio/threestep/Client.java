package cn.song.bio.threestep;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            //1. 获取服务端通信套接字
            Socket socket = new Socket("127.0.0.1", 9999);
            //2. 获取输出字节流
            OutputStream outputStream = socket.getOutputStream();
            //3. 包装打印流
            PrintStream printStream = new PrintStream(outputStream);

            Scanner scanner = new Scanner(System.in);
            String message = null;

            //4. 自旋输出到服务端
            while (true){
                System.out.print("请输入你想发送的的消息：");
                message = scanner.nextLine();
                printStream.println(message);
                printStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
