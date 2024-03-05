package com.cskaoyan.javase.UDPSocket.V4;

import com.cskaoyan.javase.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-05 08:40
 **/

public class ReceiveTask implements Runnable{
    DatagramSocket datagramSocket;

    public ReceiveTask(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        //只接收到数据
        while (true){
            //创建用于接收上的数据报包
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            try {
                datagramSocket.receive(receivePacket);
                String s = NetworkUtils.parseMsg(receivePacket);
                System.out.println("接收到了来自:" + receivePacket.getSocketAddress() + "的消息: " + s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /*用于接收的任务类ReceiveTask*/
    //成员变量:DatagramSocket

}
