package com.cskaoyan._8threadpool._3exercise;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable 做运算 返回运算结果
 * 创建2个线程  1个线程计算1+2+3...100    另一个线程计算1+2+3+...200
 *
 * @since 10:57
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 分别创建两个任务
        CalcTask ct1 = new CalcTask(100);
        CalcTask ct2 = new CalcTask(200);
        // 创建FutureTask对象
        FutureTask<Integer> ft1 = new FutureTask<>(ct1);
        FutureTask<Integer> ft2 = new FutureTask<>(ct2);
        // 创建Thread对象
        new Thread(ft1).start();
        new Thread(ft2).start();
        // 获取返回值
        System.out.println(ft1.get());
        System.out.println(ft2.get());
    }
}
//需要返回int类型的值
class CalcTask implements Callable<Integer> {
    private int num;

    public CalcTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result += i;
            Thread.sleep(10);
        }
        return result;
    }
}