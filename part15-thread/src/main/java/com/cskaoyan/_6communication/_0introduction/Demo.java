package com.cskaoyan._6communication._0introduction;

/**
 * 生产者-消费者模型,简单版本,只使用线程同步来维护多线程下的数据安全,维护生产和消费的基本秩序
 *
 * @since 14:29
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    private static int goodsNum = 0;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        System.out.println("目前商品数是" + goodsNum);
        long start = System.currentTimeMillis();
        new Thread(() -> {
            while (System.currentTimeMillis() - start <= 100) {
                synchronized (LOCK) {
                    goodsNum++;
                    System.out.println("生产者生产了商品,目前商品数是" + goodsNum);
                }
            }
        }).start();

        new Thread(() -> {
            while (System.currentTimeMillis() - start <= 100) {
                if (goodsNum > 0) {
                    synchronized (LOCK) {
                        goodsNum--;
                        System.out.println("消费者消费了商品,目前商品数是" + goodsNum);
                    }
                }
            }
        }).start();
    }
}
//threadCommunication