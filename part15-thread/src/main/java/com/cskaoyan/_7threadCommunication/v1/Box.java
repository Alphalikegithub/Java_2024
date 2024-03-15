package com.cskaoyan._7threadCommunication.v1;

/**
 * @program: Java_2024
 * @description: 蒸笼类
 * @create: 2024-03-14 10:53
 **/
//定义蒸笼类
public class Box {
    //定义 成员变量
    Food food;
    //表示包子
    /*定义三个方法*/
    //生产包子的方法（只有生产者执行)
    public void setFood(Food newFood){
        //表示包子被生产了
        food = newFood;
        System.out.println(Thread.currentThread().getName() + "生产了" + food);
    }
    //吃包子的方法（只有消费者执行）
    public void eatFood(){
        //表示包子被吃了
        System.out.println(Thread.currentThread().getName() + "吃了" + food);
        food = null;
    }
    //判断蒸笼状态的方法
    public boolean isEmpty(){
        return food == null;
        //true 蒸笼为空
        //false 蒸笼非空
    }
}

//定义包子类
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
