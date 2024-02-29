package com.cskaoyan.javase.string;

import java.util.Random;
import java.util.Scanner;

/**
 * @program: Java_2024
 * @description: 用户名 密码
 * @create: 2024-02-24 17:12
 **/

public class Demo1 {
    public static void main(String[] args) {
        //定义用户名和密码
        String username = "admin";
        String password = "admin";
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            //取值 0 1 2
            //输入
            System.out.println("请输入用户名：");
            String user = scanner.nextLine();
            System.out.println("请输入密码");
            String pwd = scanner.nextLine();

            //判断输入的内容是否正确
            if (user.equals(username) && pwd.equals(password)) {
                System.out.println("登录成功");
                //开始游戏
                System.out.println("即将开始游戏：");
                guessNum();
                break;
            } else {
                //有错的情况  代表输入密码的次数过多
                if (2 - i == 0) {
                    System.out.println("账号被锁定");
                    break;
                } else {
                    System.out.println("信息输入有误！请重新输入");
                }
            }
        }
    }
    private static void guessNum(){
        //生成一个随机数0 - 100
        Random random = new Random();
        int randomNum = random.nextInt(101);
        System.out.println("提示：数字为："+randomNum);
        Scanner scanner1 = new Scanner(System.in);

        //进行判断
        while(true)
        {
            System.out.println("请输入一个数字");
            int i = scanner1.nextInt();
            //进行判断
            if(i>randomNum)
            {
                System.out.println("数字大了");
            } else if (i < randomNum) {
                System.out.println("数小了");
            }
            else{
                System.out.println("恭喜你，猜到正确的数字了");
                break;
            }
        }
    }
}
