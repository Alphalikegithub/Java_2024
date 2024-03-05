package com.cskaoyan.javase.UDPSocket.V3;

import com.cskaoyan.javase.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @program: Java_2024
 * @description: 第三个版本，发送端和接收端相互发送
 * @create: 2024-03-04 23:36
 **/

public class Sender {
    public static void main(String[] args) throws IOException {
        /*第一部分*/
        //创建Socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8989);
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        //while处理
        while (true){
            //键盘接收
            String s = scanner.nextLine();
            //把数据封装成数据报包
            DatagramPacket sendPacket = NetworkUtils.getSendPacket(s, "127.0.0.1", 9999);
            //发送send
            datagramSocket.send(sendPacket);

            /*第二部分*/
            //构建用于接收的数据包
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            //receive接收数据
            //利用上一步创建的同一个socket对象
            datagramSocket.receive(receivePacket);
            //解析数据
            String s1 = NetworkUtils.parseMsg(receivePacket);
            System.out.println("接收到了来自:" + receivePacket.getSocketAddress() + "的消息"+ s1);
        }



    }
}
