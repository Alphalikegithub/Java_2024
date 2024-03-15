package com.cskaoyan.javase.TcpSocket.V4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Java_2024
 * @description: 服务端
 * @create: 2024-03-15 10:28
 **/

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端socket对象
        ServerSocket serverSocket = new ServerSocket(8989);
        //创建一个自己的字节输出流对象
        FileOutputStream out = new FileOutputStream("D:\\FileUpLoad\\download\\copy.png");
        //accept方法建立连接 得到socket对象
        Socket socket = serverSocket.accept();
        //从socket中获取输入流
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readCount;
        //边读边写
        while ((readCount = in.read(bytes)) != -1) {
            out.write(bytes,0,readCount);
        }
        //while结束 说明数据成功保存服务端
        //增加需求 给客户端反馈：文件上传成功
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("文件上传成功".getBytes());
        //close
        out.close();
        socket.close();
        serverSocket.close();
    }
}
