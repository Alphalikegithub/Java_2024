package com.cskaoyan._7threadCommunication.v1;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-14 11:24
 **/

public class testDemo {
    public static void main(String[] args) {
        //创建蒸笼对象
        Box box = new Box();
        //创建生产者任务和消费者任务
        ProducerTask producerTask = new ProducerTask(box);
        ConsumerTask consumerTask = new ConsumerTask(box);

        new Thread(producerTask,"生产者").start();
        new Thread(consumerTask,"消费者").start();
    }
}
