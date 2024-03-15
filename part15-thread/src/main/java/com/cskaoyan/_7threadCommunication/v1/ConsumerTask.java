package com.cskaoyan._7threadCommunication.v1;

/**
 * @program: Java_2024
 * @description: 消费者任务
 * @create: 2024-03-14 10:52
 **/

public class ConsumerTask implements Runnable{
    //定义成员变量
    Box box;

    public ConsumerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            synchronized (box){
                //判断蒸笼状态
                if(box.isEmpty()){
                    //如果蒸笼为空 说明没有包子
                    //阻止自己吃
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    //如果蒸笼非空 说明蒸笼内由包子
                    //吃包子 通知生产者notify生产 包子u
                    box.eatFood();
                    box.notify();
                }
            }

        }
    }
}
