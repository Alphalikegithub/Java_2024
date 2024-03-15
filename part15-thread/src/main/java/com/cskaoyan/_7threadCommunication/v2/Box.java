package com.cskaoyan._7threadCommunication.v2;

/**
 * @program: Java_2024
 * @description: 蒸笼类
 * @create: 2024-03-14 11:43
 **/
//做个智能蒸笼 把所有逻辑判断放到Box类中

public class Box {
    Food food;

    //    //判断蒸笼状态的方法
//    public boolean isEmpty(){
//        return food == null;
//        //true 蒸笼为空
//        //false 蒸笼非空
    //生产包子的方法（只有生产者执行)
    /*同步方法的锁对象是this*/
    public synchronized void setFood(Food newFood) {
        //判断蒸笼状态
        if (food == null) {
            //如果蒸笼为空
            //生产包子 放入蒸笼
            //表示包子被生产了
            food = newFood;
            System.out.println(Thread.currentThread().getName() + "生产了" + food);
//            //通知消费者来吃
//            this.notify();
            //多个生产者和消费者的时候修改为notifyAll()
            this.notifyAll();
        } else {
            //如果蒸笼非空
            //说明有包子 阻止自己生产 wait
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //吃包子的方法（只有消费者执行）
    public synchronized void eatFood() {
        //判断蒸笼状态
        if(food == null){
            //如果蒸笼为空 表示没有包子
            //阻止自己吃 wait
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            //如果蒸笼非空 说明有包子
            //吃包子 通知生产者生产notify
            System.out.println(Thread.currentThread().getName() + "吃了" + food);
            food = null;
            this.notify();
            //多个生产者和消费者的时候修改为notifyAll()
            this.notifyAll();
        }

    }

}

//包子类
class Food {
    String name;
    int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
