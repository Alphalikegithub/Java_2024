package com.cskaoyan.javase.utils;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-04 23:14
 **/

public class NetworkUtils {
    //创建用于发送的数据报包
    public static DatagramPacket getSendPacket(String msg,String ip,int port) throws UnknownHostException {
        byte[] bytes = msg.getBytes();
        InetAddress inetAddress = InetAddress.getByName(ip);
        DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, inetAddress, port);
        //返回数据报包
        return sendPacket;
    }
    //创建用于接收的数据报包
    public static DatagramPacket getReceivePacket(){
        byte[] bytes = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);
        //返回一个空的数据报包
        return receivePacket;
    }
    //解析数据
    public static String parseMsg(DatagramPacket receivePacket){
        //获取数据
        byte[] data = receivePacket.getData();
        int offset = receivePacket.getOffset();
        int length = receivePacket.getLength();
        //解析
        String s = new String(data, offset, length);
        //返回新的字符串
        return s;
    }
}
