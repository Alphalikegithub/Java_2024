package com.cskaoyan.javase.UDPSocket.V1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Java_2024
 * @description: 客户端（接收端）
 * @create: 2024-03-04 23:00
 **/

public class Receiver {
    public static void main(String[] args) throws IOException {
        //创建接收端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //构建一个空的数据包用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        //利用receive方法接收数据
        System.out.println("receive before");
        datagramSocket.receive(datagramPacket);
        System.out.println("receive after");
        //解析数据
        byte[] data = datagramPacket.getData();
        int offset = datagramPacket.getOffset();
        int length = datagramPacket.getLength();
        String s = new String(data,offset,length);
        System.out.println("s = " + s);
        //close
        datagramSocket.close();
    }
}
