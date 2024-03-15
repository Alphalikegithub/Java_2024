package com.cskaoyan.javase.TcpSocket.V4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: Java_2024
 * @description: 客户端上传文件到服务器
 * @create: 2024-03-15 10:16
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端socket对象
        Socket socket = new Socket("172.16.4.91", 8989);
        //创建1个自己的字节输入流对象
        FileInputStream fileInputStream = new FileInputStream("D:\\FileUpLoad\\upload\\Screenshots.png");
        //从socket中获取输出流
        OutputStream out = socket.getOutputStream();
        //边读边写while
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = fileInputStream.read(bytes)) != -1) {
            out.write(bytes,0,readCount);
        }
        //while 结束说明文件数据发送完了
        //禁用此套接字的输出流
        socket.shutdownOutput();//半关闭
        //增加需求 接收反馈消息
        InputStream inputStream = socket.getInputStream();
        byte[] bytes1 = new byte[1024];
        int readCount2 = inputStream.read(bytes1);
        System.out.println(new String(bytes1, 0, readCount2));
        //close
        fileInputStream.close();
        socket.close();
    }
}
