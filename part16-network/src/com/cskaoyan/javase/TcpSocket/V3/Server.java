package com.cskaoyan.javase.TcpSocket.V3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Java_2024
 * @description: 服务端
 * @create: 2024-03-15 09:42
 **/

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端的socket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //accept建立连接 得到socket对象
        Socket socket = serverSocket.accept();
        /*读取客户端的数据*/
        //从socket中获取输入流
        InputStream inputStream = socket.getInputStream();
        //read数据
        byte[] bytes = new byte[1024];
        int readCount = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, readCount));

        /*给客户端反馈消息*/
        //从socket中获取输出流
        OutputStream out = socket.getOutputStream();
        //write
        out.write("长风破浪会有时，直挂云帆济沧海".getBytes());
        //close
        socket.close();
        serverSocket.close();
    }
}
