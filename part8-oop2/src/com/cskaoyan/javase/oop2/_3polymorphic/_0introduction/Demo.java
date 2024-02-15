package com.cskaoyan.javase.oop2._3polymorphic._0introduction;

/**
 * @program: Java_2024
 * @description: 多态的引入
 * @create: 2024-01-18 08:29
 **/
/*
* 多态的本质是，方法调用的结果根据对象的具体类型来决定，子类中如果重写了父类方法，而父类引用指向不同对象
* 那么在调用这个被重写的方法时，会根据对象的具体类型不同，体现出不同的行为*/
public class Demo {
    public static void main(String[] args) {
        //同一个父类引用
        Phone p;
        p = new Phone();
        p.call();
        //指向不同的子类对象
        p = new IPhone();
        p.call();;
        p= new HuaWei();
        p.call();;
        p = new XiaoMi();
        p.call();
    }
}
class Phone{
    public void call(){
        System.out.println("打电话");
    }
}
class IPhone extends Phone{
    @Override
    public void call(){
        System.out.println("嘿！siri");
    }
}
class HuaWei extends Phone{
    @Override
    public void call(){
        System.out.println("不用华为不爱国");
    }
}
class XiaoMi extends Phone{
    @Override
    public void call(){
        System.out.println("你好，我是小爱同学");
    }
}