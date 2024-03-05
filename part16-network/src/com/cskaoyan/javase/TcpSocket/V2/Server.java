package com.cskaoyan.javase.TcpSocket.V2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-05 10:05
 **/
//有多个客户端连接的时候，可以放到线程中进行处理
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        /*while (true) {
            Socket socket = serverSocket.accept();
            // 创建新的线程并启动
            new Thread(new ConnectTask(socket)).start();
            // 阻止服务端断开与客户端的连接
            socket.setKeepAlive(true);
        }*/
        while(true){
            Socket socket = serverSocket.accept();
            //使用线程池
            //提交任务给线程池
            pool.submit(new ConnectTask(socket));
        }
    }
}

//定义一个读取数据的任务
class ConnectTask implements Runnable {

    //定义成员变量
    Socket socket;

    public ConnectTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取输入流
        //读取数据
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            String msg = new String(bytes, 0, read);
            System.out.println(Thread.currentThread().getName() + "---" + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
