package cn.song.bio.fourstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TaskRun  implements Runnable{

    private Socket socket;

    public TaskRun(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("获取通信客户端的输入流");
            //1.获取与客户端通信的输入流
            InputStream inputStream = socket.getInputStream();
            //2. 将字节输入流包装成缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message = null;
            //3. 自旋读取客户端发来的消息
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("获取->" + socket.getPort() + ":" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
