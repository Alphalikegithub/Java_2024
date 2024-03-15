package com.cskaoyan._8timertask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-15 00:57
 **/

public class Demo {
    public static void main(String[] args) throws ParseException {
        //创建一个定时器
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        //进行调度
        //1.public void schedule(java.util.TimerTask task,long delay, long period )
        //timer.schedule(myTask, 5000, 3000);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "2024-03-15 08:49:59";
        Date date = simpleDateFormat.parse(s);
        //2.public void schedule(java.util.TimerTask task, java.util.Date time )
        //timer.schedule(new MyTask(),date);
        //3.public void schedule(java.util.TimerTask task, java.util.Date firstTime,long period )
        //timer.schedule(new MyTask(),date,5000);
        //4.public void scheduleAtFixedRate(     java.util.TimerTask task,long delay,long period )
        timer.scheduleAtFixedRate(new MyTask(),3000,3000);

        //取消定时器cancel
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timer.cancel();
    }
}

//定义定时任务
class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("炸弹爆炸了 Boom!");
    }
}
