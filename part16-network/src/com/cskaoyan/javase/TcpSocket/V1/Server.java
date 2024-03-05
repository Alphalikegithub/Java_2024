package com.cskaoyan.javase.TcpSocket.V1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Java_2024
 * @description: 服务端
 * @create: 2024-03-05 09:23
 **/

public class Server {
    public static void main(String[] args) throws IOException {

        //创建服务端Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(8888);
        //执行accept方法，与客户端建立连接，得到返回值socket对象
        Socket socket = serverSocket.accept();
        //从socket对象中获取输入输出流
        InputStream inputStream = socket.getInputStream();
        //利用输入输出流进行读写操作
        byte[] bytes = new byte[1024];
        int readCount = inputStream.read(bytes);
        System.out.println(new String(bytes,0,readCount));
        socket.close();
        serverSocket.close();
    }
}
