package cn.song.bio.file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class FileSaveThread implements Runnable {

    private Socket socket;

    public FileSaveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("接收客户端上传请求");
            //获取客户端输入流
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //获取文件格式以及本地输出文件
            String s = dataInputStream.readUTF();
            File file = new File("/Users/kollorsong/Documents/back/" + UUID.randomUUID() + "." + s);
            if (!file.exists()){
                File parentFile = file.getParentFile();
                if (!parentFile.exists())
                    parentFile.mkdirs();
                file.createNewFile();
            }
            //获取数据输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            byte[] buffer = new byte[1024 * 2];
            int le = 0;

            while ((le = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, le);
            }

            System.out.println("文件：" + s + "写入完成");

            fileOutputStream.close();
            dataInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
