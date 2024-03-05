package com.cskaoyan.javase.UDPSocket.V2;

import com.cskaoyan.javase.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: Java_2024
 * @description: 使用工具类封装的UDP通信
 * @create: 2024-03-04 23:09
 **/

public class Sender {
    public static void main(String[] args) throws IOException {
        //创建发送的Socket对象
        DatagramSocket datagramSocket = new DatagramSocket(1212);
        //封装成数据包
        DatagramPacket sendPacket = NetworkUtils.getSendPacket("java其实挺容易学的", "127.0.0.1", 8089);
        //发送
        datagramSocket.send(sendPacket);
        datagramSocket.close();
    }
}
