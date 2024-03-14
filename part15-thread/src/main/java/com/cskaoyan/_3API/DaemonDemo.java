package com.cskaoyan._3API;

/**
 * @program: Java_2024
 * @description:守护线程
 * @create: 2024-03-11 23:16
 **/

public class DaemonDemo {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        //将该线程设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        //每打印1个数 休息1s
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "-----" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
