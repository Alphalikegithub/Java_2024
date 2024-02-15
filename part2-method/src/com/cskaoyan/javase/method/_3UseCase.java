package com.cskaoyan.javase.method;

import static com.sun.javafx.fxml.expression.Expression.multiply;

/*方法可以减少代码冗余*/
public class _3UseCase {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));

        int result = getMultiply();
        System.out.println(result);
    }

    private static int getMultiply() {
        int c = 10;
        int d = 20;
        int i = c * d;
        return i;
    }

    public static int getSum(int a, int b) {
        int sum = a + b;
        return sum;
    }
}
