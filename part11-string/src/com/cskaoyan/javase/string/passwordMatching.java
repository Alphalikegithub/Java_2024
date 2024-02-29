package com.cskaoyan.javase.string;

/**
 * @program: Java_2024
 * @description: 穷举匹配密码
 * @create: 2024-02-29 08:50
 **/

public class passwordMatching {
    public static void main (String[] args){
        String randomPassword = getRandomPassword(3);
    }
    private static String getRandomPassword(int len){
        String pool = "";
        for (int i = '0'; i < '9'; i++) {
            pool += ((char)i);
        }
        System.out.println(pool);
        return null;
    }
    private static void matchPassword(String password){
        //所有的可能性0-999
        for (int i = 0; i < 1000; i++) {
            String possiblePassword = String.format("03d",i);
            System.out.println(possiblePassword);
            if(password.equals(possiblePassword)){
                System.out.println("匹配到了密码，密码是:"+ possiblePassword);
                break;
            }
        }
    }
}
