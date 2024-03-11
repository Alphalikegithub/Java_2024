package com.cskaoyan.io2._01practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: Java_2024
 * @description: 多次键盘录入
 * @create: 2024-03-08 08:44
 **/

public class ScannerTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //循环读取
        String line;
        //结束标志为gun
        while((line = reader.readLine()) != null){
            if("gun".equals(line)){
                break;
            }
            System.out.println(line);
        }
    }
}
