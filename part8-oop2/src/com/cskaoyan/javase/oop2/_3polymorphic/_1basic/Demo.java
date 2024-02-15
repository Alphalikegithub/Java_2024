package com.cskaoyan.javase.oop2._3polymorphic._1basic;

/**
 * @program: Java_2024
 * @description: 多态的访问特征
 * @create: 2024-01-18 08:41
 **/
/*
* 强转很危险，Java引入intanceof关键字 规避不合理的强转
* 语法： 引用 instanceof 类名
* 表示判断 引用指向的对象，是否为后面类名的对象或子类对象
* */
public class Demo {
    public static void main(String[] args) {
        /*collectCatShout(new Cat());
        Animal animal;
        animal = new Cat();
        animal.shouting();
        animal = new Dog();
        animal.shouting();*/
        //父类引用指向不同的子类对象
        //调用子类中重写的同名成员方法
        //根据传入子类对象的不同，体现出不同的行为
        //这就是多态
        collectAnimalShout(new Cat());
        collectAnimalShout(new Dog());
        collectAnimalShout(new Person());

        Teacher teacher = new Teacher("新的字符串");
        Teacher teacher1 = new Teacher("测试构造函数",234,9999);
        System.out.println("测试字符串   "+ teacher1.array + "测试long类型   " + teacher1.number + "测试double类型   " + teacher1.count);

    }

    /*//收集研究猫的叫声
    public static void collectCatShout(Cat cat) {
        cat.shouting();
    }*/
    //收集动物的叫声
    public static void collectAnimalShout(Animal animal) {
        animal.shouting();
        //为了访问子类独有成员，需要将父类引用转换成子类引用
        /* 子类引用的类名 对象名 = (子类引用的类名)父类引用 */
        //强转
        //为了更好的在a引用指向Person对象时做强转，需要使用instanceof判断
        if(animal instanceof Person)
        {
            Person p_animal = (Person) animal;
            p_animal.addMoney();
        }

        /*Cat cat1 = (Cat)animal;
        Person animal1 = (Person) animal;
        Dog animal2 = (Dog) animal;
        Cat animal3 = (Cat) animal;*/





    }
}

class Animal {
    String name;

    public void shouting() {
        System.out.println("动物的 叫声");
    }
}

class Cat extends Animal {
    @Override
    public void shouting() {
        System.out.println("喵喵喵");
    }
}

class Dog extends Animal {
    @Override
    public void shouting() {
        System.out.println("汪汪汪");
    }
}
class Person extends Animal{
    //子类独有的成员方法
    public void addMoney(){
        System.out.println("加钱才行");
    }
    @Override
    public void shouting() {
        System.out.println("嘤嘤嘤");
    }

}
class Teacher{
    static  int name = 30;
    String array ;
    double count ;
    long number;
    public Teacher(String array1) {
        this.array = array1;
    }
    public Teacher(String array2,double counts,long numbers){
        this(array2);
        this.count = counts;
        this.number = numbers;
    }

    public static int getName() {
        return name;
    }

    public static void setName(int name) {
        Teacher.name = name;
    }

    public String getArray() {
        return array;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}