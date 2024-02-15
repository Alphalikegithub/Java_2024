package com.cskaoyan.javase.junit._0introduction;

import org.junit.Test;

/**
 * 当前阶段:
 * Junit可以在同一个类中实现多个main方法的效果，它是非常好的测试工具。在JavaSE阶段可以用来测试各种demo或者idea。
 *
 * 基本使用
 * 这里简单介绍一下它的基本使用，你可能不懂为啥这么做，先比葫芦画葫芦，以后都会懂的。
 * 使用步骤:
 *      1.找到一个类,这个类最好不要叫Test
 *      2.在类体的空白处写注解: "@Test"
 *      3.alt + 回车 报错的位置
 *      4.在"@Test"注解下面写测试方法,测试方法的格式是:
 *          public void 方法名(){
 *              // 方法体
 *          }
 *      5.把需要执行的代码写在测试方法的方法体当中
 *      6.启动该测试方法,类似启动main方法
 *
 * 注意事项:
 *      1.既然在类中使用Junit单元测试方法了,就不要再写main方法了
 *      2.测试方法格式是固定的,除了方法的名字和方法体外,都不可以轻易修改
 *
 * 扩展:
 *      1.注解。注解（annotation）是和class同等级别的数据类型，同样是引用数据类型（你完全可以把注解看成一个类）
 *      "@Test",其中注解的名字是Test,"@"符号是实例化注解的语法
 *      Test注解实际上就可以看成Test类,它们是同等级别的数据类型
 *
 *      2.关于导包语句
 *      Scanner的导包的语句是: import java.util.Scanner 这表示使用的Scanner类是java.util包下的Scanner类
 *      Junit单元测试使用注解Test的导包语句是: import org.junit.Test; 这表示使用的注解Test是org.junit包下的Test注解
 *
 * @since 10:37
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    @Test
    public void test() {
        System.out.println("hello world!");
    }

    @Test
    public void test2() {
        System.out.println("66666666666");
    }


    @Test
    public void test3() {
        System.out.println("777777");
    }

}
