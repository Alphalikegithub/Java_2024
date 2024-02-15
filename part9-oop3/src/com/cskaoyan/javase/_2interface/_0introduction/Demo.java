package com.cskaoyan.javase._2interface._0introduction;

/**
 * @program: Java_2024
 * @description: 成员内部类
 * @create: 2024-01-25 15:17
 **/
/*
 * 1.既然成员内部类和外围类之间是好兄弟，所以他们直接互相访问都不受访问权限控制
   2.成员内部类依赖于外部对象而存在，所以：
         成员内部类当中又两个对象：（1）自身对象用this关键字指向（2）外围类用外围类类名.this指向

 */
public class Demo {
}
/*静态内部类和外部类嵌套使用，你想访问他受外围类的保护静态内部类和外部类的关系借助外围类保护自*/
class EnclosedClazz {
    int a;
    private int b = 10;
    static int c = 20;
    private static final int d = 10;
    private static final String aa = "abc";

    //定义成员内部类
    private class InnerClazz {
        int a;
        private static final int d = 10;
        static final String aa = "abc";

        public void test() {

        }
    }
}
