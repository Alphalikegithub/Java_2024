package com.cskaoyan.javase.UDPSocket.V1;

import java.io.IOException;
import java.net.*;

/**
 * @program: Java_2024
 * @description: 网络通信
 * @create: 2024-03-04 22:40
 **/

public class Sender {
    public static void main(String[] args) throws IOException {
        //0.来自应用层的数据
        String s = "hello UDP";
        //1.创建发送端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //2.把要发送的数据封装成数据包
        int port = 9999;
        InetAddress targetIP = InetAddress.getByName("127.0.0.1");
        DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(),0, s.length(),targetIP,port);
        //3.利用send方法发送数据包
        datagramSocket.send(datagramPacket);
        //4.关闭连接、
        //datagramSocket.close();
    }
}
