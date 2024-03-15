package com.cskaoyan._6communication._1basic;

/**
 * wait()
 * notify()
 * notifyAll()
 * 多线程的等待唤醒机制,也就是这三个方法的应用,(重点)这三个方法有以下共同特征:
 * 1.这些方法处在Object类当中,意味着Java的每一个类的对象都可以调用这些方法
 * 2.这些方法都是公共的,final修饰的本地方法,所以它们的具体实现以及重写都不需要考虑了
 * 3.(重点)这三个方法的调用者对象都必须是synchronized同步锁对象，否则就会抛出异常——IllegalMonitorStateException。
 *      这就意味着等待唤醒机制,必须配合同步代码块,同步方法以及静态同步方法使用
 *      不能单独使用
 * 4.(重点)为了能够实现“等待唤醒机制”，首先就要实现线程同步，并且要保证全程使用同一个锁对象,才能够实现有效的等待唤醒!
 *
 * @since 14:38
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // Unhandled exception: java.lang.InterruptedException
        new Demo().wait();
    }
}
