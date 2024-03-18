package com.cskaoyan.javase._3use;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 09:07
 **/

public class Demo {
    public static void main(String[] args) {

    }
    //使用注解的时候 注解的每个属性都需要赋值
    //可通过default关键字去设置默认值,有默认值后可简化赋值的步骤
    @MyAnno5
    @MyAnno4(Value = "嘿嘿")
    @MyAnno3(names = {"张三","李四","王五"})
    @MyAnno2(maxAge = 100,minAGe = 1)
    public static void func(){

    }
}

//定义注解
@interface MyAnno2{
    //定义注解体
    int maxAge();
    int minAGe();
}
@interface MyAnno3{
    String[] names();
}
@interface MyAnno4{
    //表示名字
    String Value();
}
@interface MyAnno5{
    //
    String role() default "员工";
}
