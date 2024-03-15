package com.cskaoyan._3implement2;

/**
 * @program: Java_2024
 * @description: 多线程的实现方式2
 * @create: 2024-03-12 00:00
 **/
/**
 * java.lang.Runnable接口
 * 方式二基于Thread类的另外两个构造器来实现创建Thread类的对象,从而实现多线程
 * Thread(Runnable)
 * Thread(Runnable,String name)
 *
 * 方式二实现的具体步骤为：
 *      1.定义一个子类A，实现Runnable接口并重写run方法。
 *      2.创建A类的对象。
 *      3.使用构造器：
 *      Thread(Runnable target)
 *      Thread(Runnable,String)
 *      来新建Thread类的对象，然后将A类的对象作为参数传递。
 *      4.调用Thread类的对象的start方法，这时会启动一个新的线程，并且JVM会自动调用重写run方法
 *
 * 注意事项:
 *      1.(重点)Runnable接口的实现类并不是表示一个线程,而是表示一个在线程中执行的任务
 *      所以Runnable接口的实现类,可以命名为"xxxTask",以表示它是一个任务
 *
 *      2.利用Thread类的构造器,将Runnable接口的实现类对象作为一个任务传递给Thread对象
 *      这样启动此线程,就会自动执行这个任务
 *      所谓的多线程多种实现方法,只不过使用的Thread类的构造器不同,本质上都是创建Thread对象
 *
 *
 *      3.Runnable接口是一个功能接口,这意味着可以用Lambda表达式写它的实现
 *      当然方式二的实现,不建议无脑用Lambda表达式
 *      因为它不方便传参
 *      当然如果没有传参的需求,用Lambda表达式确实是更好的选择
 *
 * @since 16:59
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) {
        //2.创建A类的对象。
        MyRunnable myRunnable = new MyRunnable();
        // 3.使用构造器：来新建Thread类的对象，然后将A类的对象作为参数传递。
/*        Thread(Runnable target)
        Thread(Runnable,String)*/
        Thread thread = new Thread(myRunnable);
        //4.调用Thread类的对象的start方法，这时会启动一个新的线程，并且JVM会自动调用重写run方法
        thread.start();
    }
}
//1.定义一个子类A，实现Runnable接口并重写run方法。
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("子线程");
    }
}
