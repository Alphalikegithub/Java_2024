package com.cskaoyan.javase.oop2._3polymorphic._1basic;

/**
 * @program: Java_2024
 * @description: 强制类型转换
 * @create: 2024-01-18 10:47
 **/
/*强转能够运行成功的条件是：
父类引用指向的对象，是要强转成的引用的数据类型的对象，
还可以是要强转成的引用的数据类型的子类对象*/
public class Demo2 {
    public static void main(String[] args) {
        GrandFather gf = new GrandSon();
        //gf这个引用可以强转成哪些引用？
        Father gf1 = (Father) gf;
        Son gf2 = (Son) gf;
        GrandSon gf3 = (GrandSon) gf;
        //Casting 'gf' to 'Father2' will produce 'ClassCastException' for any non-null value
        //错误的强转，回导致程序抛出异常，程序终止
        Father2 gf4 = (Father2) gf;


    }
}

class GrandFather {
}

class Father extends GrandFather {
}

class Father2 extends GrandFather {
}

class Son extends Father {
}

class GrandSon extends Son {
}
