package com.cskaoyan._5synchronized._0introduction;

/**
 * @program: Java_2024
 * @description:* 线程同步
 *  * 多线程数据安全问题的引入
 *  * 现在开发一个软件，模拟某影院售票窗口售票服务，要求如下：
 *  *      1.一共只卖100张票。
 *  *      2.影院有三个售票窗口，同时卖票，互不影响。
 *  * 用我们已经学过的知识点,来模拟一下多线程实现三个窗口售票
 *  *
 *  * 多线程的实现方式一
 *  * 三个线程,要同时卖100张票,这里就存在数据共享
 *  * 在JVM内存中,方法栈都是线程私有的,而堆和方法区都是线程共享的
 *  *
 * @create: 2024-03-13 23:30
 **/

public class Demo {
    public static void main(String[] args) {
        SellWindow window1 = new SellWindow();
        SellWindow window2 = new SellWindow();
        SellWindow window3 = new SellWindow();
        window1.setName("窗口A");
        window2.setName("窗口B");
        window3.setName("窗口C");

        window1.start();
        window2.start();
        window3.start();
    }
}
class SellWindow extends Thread{
    static int tickets = 1;

    @Override
    public void run() {
        while (true){
            if(tickets <= 100){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(getName() + "卖出了第" + tickets + "张票!");
                tickets++;
            }
        }
    }
}