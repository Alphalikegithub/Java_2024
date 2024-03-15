package com.cskaoyan._8threadpool._3exercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-15 00:39
 **/

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //不借助于线程池
        //使用FutureTask
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable2());
        //放到线程中执行
        Thread thread = new Thread(futureTask);
        thread.start();

        //接收返回值并打印
        System.out.println(futureTask.get());
    }
}
class MyCallable2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return "结束";
    }
}
