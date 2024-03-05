package com.cskaoyan.javase.TcpSocket.V2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Java_2024
 * @description: 多个客户端发送消息，服务端接收
 * @create: 2024-03-05 09:37
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket socket = new Socket("127.0.0.1", 9999);
        while(true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(s.getBytes());
        }

    }
}
