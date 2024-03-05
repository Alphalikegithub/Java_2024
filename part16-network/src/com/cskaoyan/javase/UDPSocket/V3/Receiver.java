package com.cskaoyan.javase.UDPSocket.V3;

import com.cskaoyan.javase.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-04 23:36
 **/

public class Receiver {
    public static void main(String[] args) throws IOException {
        //创建socket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //创建scanner对象
        Scanner scanner = new Scanner(System.in);
        while(true){
            //接收数据
            //构建用于接收的数据包
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            //receive
            datagramSocket.receive(receivePacket);
            //parse
            String msg = NetworkUtils.parseMsg(receivePacket);
            System.out.println("接收到了来自: " + receivePacket.getSocketAddress()  + "的消息" + msg);

            /*发送逻辑*/
            //键盘接收
            String s = scanner.nextLine();
            //把字符喜欢封装成数据包
            DatagramPacket sendPacket = NetworkUtils.getSendPacket(s, "127.0.0.1", 8989);
            //send
            datagramSocket.send(sendPacket);
        }

    }
}
