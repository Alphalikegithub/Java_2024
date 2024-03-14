package com.cskaoyan._7communication._5append.three;

/**
 * 利用StringBuffer，实现三个线程轮流向缓冲区append数据。
 * 也就是线程1追加一次，线程2追加一次，线程3再追加一次....
 * 三个线程总记共追加30次数据。
 * 提示：可以将这些线程命名为“线程1”、“线程2”、“线程3”
 *
 * 首先，两个线程轮流追加数据，追加20次
 * 思路:
 *     此时两个线程要共享同一个缓冲区,同时向缓冲区中追加数据,所以首先要做线程同步
 *     其次,为了实现轮流追加数据,需要等待唤醒
 *     某个线程追加一次后,立刻要wait自己让别人来追加,当然在wait之前,要先唤醒对方
 *
 * @since 16:39
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread(new ThreeThreadAppendTask(sb, "aaa"), "线程1");
        Thread t2 = new Thread(new ThreeThreadAppendTask(sb, "bbb"), "线程2");
        Thread t3 = new Thread(new ThreeThreadAppendTask(sb, "ccc"), "线程3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }
}


class ThreeThreadAppendTask implements Runnable {
    /*
        线程1,线程2,线程3
        第1次是线程1
        第2次是线程2
        第3次是线程4
        第4次是线程1
        第5次是线程2
        第6次是线程3
        ...
        第几次执行可以设为count次
        int count = 0;
        第(count + 1)次 线程1
        第(count + 2)次 线程2
        第(count + 3)次 线程2
        第(count + 4)次 线程1
        ....
        0(count % 3 + 1) = 线程1
        1(count % 3 + 1) = 线程2
        2(count % 3 + 1) = 线程3
        3(count % 3 + 1) = 线程1
        4(count % 3 + 1) = 线程2
        ....
        所以只需要一个count取余3就可以实现三个线程轮流执行
        if(count % 3 + 1) = 线程的编号

        具体的逻辑是:
        某个线程符合上述的要求,就是它执行,执行完了以后可以唤醒其他线程
        而如果不符合上述的要求,那就不是它执行,要wait自己,然后等待别人唤醒
     */
    private static int count = 0;
    private static final Object o = new Object();
    private StringBuffer sb;
    private String str;

    public ThreeThreadAppendTask(StringBuffer sb, String str) {
        this.sb = sb;
        this.str = str;
    }

    public void run() {
        synchronized (o) {
            while (count < 30) {
                int threadNum = Integer.parseInt(Thread.currentThread().getName().substring(2, 3));
                /*if ((count % 3 + 1) == threadNum) {
                    sb.append(str);
                    count++;
                    o.notifyAll();
                } else {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if ((count % 3 + 1) != threadNum) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    sb.append(str);
                    count++;
                    o.notifyAll();
                }
            }
        }
    }
}

