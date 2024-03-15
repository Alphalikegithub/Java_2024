package com.cskaoyan._7threadCommunication.v1;

import java.util.Random;

/**
 * @program: Java_2024
 * @description: 生产者任务
 * @create: 2024-03-14 10:52
 **/

public class ProducerTask implements Runnable{
    //定义成员变量
    Box box;
    Food[] foods = {new Food("大肉包子",2),
            new Food("韭菜包子",1),
            new Food("牛肉包子",3)};
    Random random = new Random();
    public ProducerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            synchronized (box){
                //判断蒸笼的状态
                if(box.isEmpty()){
                    //如果蒸笼为空
                    //生产包子 并放入蒸笼

                    int i = random.nextInt(foods.length);
                    box.setFood(foods[i]);
                    //通知消费者来吃notify
                    box.notify();
                }else {
                    //如果蒸笼非空
                    //说明有包子 阻止自己生产wait
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }



            }
        }
    }
}
