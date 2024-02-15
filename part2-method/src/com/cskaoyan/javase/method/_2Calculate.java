package com.cskaoyan.javase.method;

public class _2Calculate {
    public static void main(String[] args) {

        System.out.println(add(3, 4));
        System.out.println(subtract(7, 5));
        System.out.println(multiplication(3, 8));
        System.out.println(divide(6, 3));
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
