package com.cskaoyan.javase.TcpSocket.V3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: Java_2024
 * @description: 客户端发送消息，服务接收并反馈消息
 * @create: 2024-03-15 09:34
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //发送逻辑
        //从socket对象中获取输出流
        OutputStream out = socket.getOutputStream();
        //write数据
        out.write("山重水复疑无路，柳暗花明又一村".getBytes());

        //接收逻辑
        //从socket中获取输入流
        InputStream in = socket.getInputStream();
        //read
        byte[] bytes = new byte[1024];
        int readCount = in.read(bytes);
        System.out.println(new String(bytes, 0, readCount));
        //close
        socket.close();
    }
}
