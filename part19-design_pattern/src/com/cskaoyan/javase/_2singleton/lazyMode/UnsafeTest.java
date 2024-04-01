package com.cskaoyan.javase._2singleton.lazyMode;

import com.cskaoyan.javase._2singleton.lazyMode.Singleton1;
import com.cskaoyan.javase._2singleton.lazyMode.Singleton2;
import com.cskaoyan.javase._2singleton.lazyMode.Singleton3;
import org.junit.Test;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 21:28
 **/

public class UnsafeTest {
    @Test
    public void myTest1() {
        for (int i = 0; i < 88; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton1 instance3 = Singleton1.getInstance();
                    System.out.println(instance3);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton1 instance4 = Singleton1.getInstance();
                    System.out.println(instance4);
                }
            }).start();
        }
    }

    @Test
    public void myTest2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton2 instance5 = Singleton2.getInstance();
                System.out.println(instance5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton2 instance6 = Singleton2.getInstance();
                System.out.println(instance6);
            }
        }).start();
    }

    @Test
    public void myTest3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton3 instance7 = Singleton3.getInstance();
                System.out.println(instance7);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton3 instance8 = Singleton3.getInstance();
                System.out.println(instance8);
            }
        }).start();
    }
}
