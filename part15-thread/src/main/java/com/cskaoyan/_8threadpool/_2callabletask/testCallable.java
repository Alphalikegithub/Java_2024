package com.cskaoyan._8threadpool._2callabletask;

import java.util.concurrent.*;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-15 00:27
 **/

public class testCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //submit提交Callable类型的任务
        Future<String> future = pool.submit(new MyCallable());
        //获取结果
        System.out.println("get before");
        String s = future.get();
        System.out.println("get after");
        System.out.println(s);
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        Thread.sleep(5000);
        return "打印完毕";
    }
}