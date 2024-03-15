package com.cskaoyan._7threadCommunication.v2;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-14 11:43
 **/

public class ConsumerTask implements Runnable{
    Box box;

    public ConsumerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        //只做一件事 吃包子
        while (true){
            box.eatFood();
        }
    }
}
