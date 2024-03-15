package com.cskaoyan._2API;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-11 23:38
 **/

public class safeDelete {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        //main线程中每打印1个休眠1s 打印3个数
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //中断线程
        t.flag = false;
    }
}

class MyThread extends Thread {
    //定义成员变量
    boolean flag = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //判断是否发生中断
            if(flag){
                System.out.println(getName() + "-----" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                //说明此时发生了线程中断
                //中断信息保存到log.txt
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter("D:\\Java\\IdeaProjects\\Java_2024\\part15-thread\\log.txt");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = simpleDateFormat.format(new Date());
                    //write信息
                    fileWriter.write(date + getName() + "  " +"发生了中断");
                    //flush
                    fileWriter.flush();
                    //close
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
