package com.cskaoyan.javase.UDPSocket.V2;

import com.cskaoyan.javase.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-04 23:10
 **/

public class Receiver {
    public static void main(String[] args) throws IOException {
        //创建用于接收的Socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8089);
        //构建用于接收的数据报包
        DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
        //receive接收
        System.out.println("receive before");
        datagramSocket.receive(receivePacket);
        System.out.println("receive after");
        //解析
        String msg = NetworkUtils.parseMsg(receivePacket);
        System.out.println("msg = " + msg);

        datagramSocket.close();
    }
}
