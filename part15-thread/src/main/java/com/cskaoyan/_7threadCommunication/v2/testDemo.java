package com.cskaoyan._7threadCommunication.v2;

/**
 * @program: Java_2024
 * @description: 测试
 * @create: 2024-03-14 17:22
 **/

public class testDemo {
    public static void main(String[] args) {
        //创建蒸笼对象
        Box box = new Box();
        //创建生产者任务
        ProducerTask producerTask = new ProducerTask(box);
        //创建消费者任务
        ConsumerTask consumerTask = new ConsumerTask(box);
        //创建2个线程
        //start
        new Thread(producerTask,"生产者").start();
        new Thread(consumerTask,"消费者").start();
        new Thread(producerTask,"生产者1").start();
        new Thread(consumerTask,"消费者1").start();
    }
}
