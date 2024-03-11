package com.cskaoyan._0introduction;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static boolean flag = true;
    public static void main(String[] args) {

        System.out.println("sayHello Before");
        sayHello();
        System.out.println("sayHello After");

        System.out.println("wait Before");
        waitToStop();
        System.out.println("wait After");
    }

    private static void waitToStop() {
        Scanner scanner = new Scanner(System.in);

        while(flag){
            String s = scanner.nextLine();
            if("gun".equals(s)){
                //修改flag值
                flag = false;
                break;
            }
        }
    }

    private static void sayHello() {
        while (flag){
            System.out.println("Hello world!");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}