package com.cskaoyan._5lock._1dielock;

/**
 * @program: Java_2024
 * @description: 死锁
 *  * 死锁
 *  * 锁也是一种资源，如果出现两个线程都同时在等待对方的锁，这样两个线程都会停滞，这就是死锁现象。
 *  *
 *  * 那么如何解决死锁呢?
 *  *      1.套一把更大的锁
 *  *      2.改变竞争锁的顺序,避免出现互相竞争对方锁的情况
 * @create: 2024-03-14 08:40
 **/

public class Demo {
    public static void main(String[] args) {
        DieLock dieLock1 = new DieLock(false);
        DieLock dieLock2 = new DieLock(true);

        new Thread(dieLock1).start();
        new Thread(dieLock2).start();
    }
}
//定义个锁类
class MyLock{
    public static final Object objA = new Object();
    public static final Object objB = new Object();
}
class DieLock implements Runnable{
    boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //同步代码块嵌套
        if(flag){
            synchronized (MyLock.objA){
                System.out.println("if A");
                synchronized (MyLock.objB){
                    System.out.println("if B");
                }
            }
        }else{
            synchronized (MyLock.objB){
                System.out.println("else B");
                synchronized (MyLock.objA){
                    System.out.println("else A");
                }
            }
        }
    }
}