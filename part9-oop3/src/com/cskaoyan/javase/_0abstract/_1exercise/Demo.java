package com.cskaoyan.javase._0abstract._1exercise;

/**
 * @program: Java_2024
 * @description: 员工类的抽象类练习
 * @create: 2024-01-19 15:25
 **/
/*
普通员工
程序员
经理
*/
public class Demo {
    public static void main(String[] args) {
        AbstractStaff as;
        as = new NormalStaff();
        as.work();
        as = new Coder();
        as.work();
        //访问Coder独有的方法
        if (as instanceof Coder) {
            Coder coder = (Coder) as;
            coder.overtimeWork();
        }
        as = new Manager();
        as.work();

        //创建对象并测试
        NormalStaff normalStaff1 = new NormalStaff("张三", 34, 1000);
        normalStaff1.printStaff();
        Coder coder1 = new Coder("李四", 35, 3000);
        coder1.printStaff();
        Manager manager1 = new Manager("王麻子", 36, 5000, 200);
        manager1.printStaff();
    }
}

//抽象父类
abstract class AbstractStaff {
    private String name;
    private int id;
    private double salary;

    public AbstractStaff() {

    }
    //给抽象父类写一个构造方法

    public AbstractStaff(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    //抽象方法
    public abstract void work();

    //普通员工和程序员的属性是一样的
    public void printStaff() {
        System.out.println("id为" + id + "的员工，他的姓名是" + name + "他的薪水是：" + salary);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

//具体子类
class NormalStaff extends AbstractStaff {
    @Override
    public void work() {
        System.out.println("我负责杂项工作");
    }

    public NormalStaff() {
    }

    public NormalStaff(String name, int id, double salary) {
        super(name, id, salary);
    }
}

class Coder extends AbstractStaff {
    @Override
    public void work() {
        System.out.println("我负责技术开发");
    }

    //程序员独有的方法
    public void overtimeWork() {
        System.out.println("我996");
    }

    public Coder() {
    }

    public Coder(String name, int id, double salary) {
        super(name, id, salary);
    }
}

class Manager extends AbstractStaff {
    //经理Manager独有的成员变量
    private double bonus;

    @Override
    public void work() {
        System.out.println("我负责统筹规划");
    }

    public Manager() {
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    //重写printStaff方法，因为经理Manager独有的成员变量bonus
    @Override
    public void printStaff() {
        //System.out.println("id为" + id + "的员工，他的姓名是" + name + "他的薪水是：" + salary);
        //上面的id name salary是private修饰，访问不到
        System.out.println("id为" + getId() + "的员工，他的姓名是" + getName() + "他的薪水是：" + (getSalary() + bonus));
    }
}

