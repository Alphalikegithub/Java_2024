package com.cskaoyan._7threadCommunication.v2;


import java.util.Random;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-14 11:42
 **/

public class ProducerTask implements Runnable {
    Box box;
    Food[] foods = {new Food("大肉包子", 2),
            new Food("韭菜包子", 1),
            new Food("牛肉包子", 3)};
    Random random = new Random();

    public ProducerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        //只做一件事 生产包子
        while (true){
            int i = random.nextInt(foods.length);
            box.setFood(foods[i]);
        }

    }
}
