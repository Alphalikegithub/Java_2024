package com.cskaoyan.javase.UDPSocket.V4;

import com.cskaoyan.javase.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-05 08:32
 **/


public class SendTask implements Runnable{
    /*定义用于发送的任务类SendTask*/
    //成员变量:ip port DatagramSocket(发给谁)
    String ip;
    int port;
    DatagramSocket datagramSocket;

    public SendTask(String ip, int port, DatagramSocket datagramSocket) {
        this.ip = ip;
        this.port = port;
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        //只发送消息
        while ((true)) {
            String s = scanner.nextLine();
            try {
                DatagramPacket sendPacket = NetworkUtils.getSendPacket(s, ip, port);
                datagramSocket.send(sendPacket);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
