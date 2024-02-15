package com.cskaoyan.javase.method;
/*键盘输入两个最大值并进行比较*/

import java.util.Scanner;

public class _1exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println(getMaxByScanner(sc));

            System.out.println("是否继续？（Y/N）");
            String str = sc.next();
            if (str.equals("Y")) {
                flag = true;
            } else {
                flag = false;
            }
        }
    }

    public static int getMaxByScanner(Scanner sc) {
        System.out.println("请输入两个整数");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        return (num1 > num2) ? num1 : num2;

    }
}
