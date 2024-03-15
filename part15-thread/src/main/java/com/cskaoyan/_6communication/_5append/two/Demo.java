package com.cskaoyan._6communication._5append.two;

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
        Thread t1 = new Thread(new TwoTheadAppendTask(sb, "aaa"), "线程1");
        Thread t2 = new Thread(new TwoTheadAppendTask(sb, "bbb"), "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }
}

class TwoTheadAppendTask implements Runnable {
    // 两个线程要共享同一个缓冲区,也就是共享同一个StringBuffer对象
    private StringBuffer sb;
    private String str;
    private static final Object o = new Object();
    private static int i = 0;

    public TwoTheadAppendTask(StringBuffer sb, String str) {
        this.sb = sb;
        this.str = str;
    }

    @Override
    public void run() {
        synchronized (o) {
            for (; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "第" + i + "次打印了" + str);
                sb.append(str);
                o.notify();
                /*
                   A i=0, 追加aaa wait自己 没来得及i++就阻塞了
                   B i=0, 追加bbb wait自己 没来得及i++就阻塞了
                   A i=1, 追加aaa wait自己 没来得及i++就阻塞了
                   B i=2, 追加bbb wait自己 没来得及i++就阻塞了
                   A i=3, 追加aaa wait自己 没来得及i++就阻塞了
                   B i=4,
                   A i=9
                   B 进行发现i=10进不去了 B直接结束 notify A
                   A 进去了 发现i=10进不去了 A直接结束
                 */
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            o.notify();
        }
    }
}
