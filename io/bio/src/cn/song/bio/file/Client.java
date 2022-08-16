package cn.song.bio.file;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            //1. 创建服务器套接字
            Socket socket = new Socket("127.0.0.1", 8888);
            //2. 获得对服务端输出流
            OutputStream outputStream = socket.getOutputStream();
            //3. 包装数据输出流
            DataOutputStream dataInputStream = new DataOutputStream(outputStream);
            //4. 输出文件格式
            dataInputStream.writeUTF("pdf");
            //5. 获取文件
            File file = new File("/Users/kollorsong/Documents/netty 4.x 用户指南 - v1.0.pdf");

            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[1024 * 2];
            int len = 0;

            //读取文件内容写入到输出流
            while ((len = fileInputStream.read(buffer)) > 0) {
                dataInputStream.write(buffer, 0, len);
            }
            dataInputStream.flush();

            dataInputStream.close();
            fileInputStream.close();

            socket.shutdownOutput();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
