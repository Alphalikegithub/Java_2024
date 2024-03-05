package com.cskaoyan.javase.TcpSocket.V1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: Java_2024
 * @description: 客户端
 * @create: 2024-03-05 09:17
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        //创建以流套接字并将其连接到指定主机上的端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //
        //从socket对象获取输入输出流
        OutputStream outputStream = socket.getOutputStream();
        //利用输入输出流进行读写操作
        outputStream.write("hello tcp".getBytes());
        //close
        socket.close();
    }
}
