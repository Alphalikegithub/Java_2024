package com.cskaoyan.javase.UDPSocket.V4;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-05 08:47
 **/

public class AnotherPerson {
    public static void main(String[] args) throws SocketException {
        //创建DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket(8989);
        //创建两个任务分别用于接收和发送
        SendTask sendTask = new SendTask("127.0.0.1", 8888, datagramSocket);
        ReceiveTask receiveTask = new ReceiveTask(datagramSocket);
        //创建两个线程 并启动
        new Thread(sendTask).start();
        new Thread(receiveTask).start();
    }
}
