package com.cskaoyan.javase._1interface._0introduction;

/**
 * 接口的引入
 * 现在我们有了新需求：一部分猫和狗，经过了特殊训练，能够直立行走了。那么这群特殊的猫和狗，怎么描述它们呢？
 * 分析：
 *
 * 部分猫和狗经过特殊训练，才能够直立行走。所以不可能直接加个方法到Cat类和Dog类中，不是所有猫狗都有这个行为。而特殊的猫狗仍然是猫和狗，所以它们肯定还要继承猫和狗这两个类。可能很多同学，这时候想到的就是：重新定义两个新的猫狗类（比如超级狗和猫）继承猫狗，然后给出直立行走的方法就算完事了。这样做不是不行，需求是实现了，但还有一些小问题：
 *
 * 一方面没有体现代码复用。
 * 更重要的是，没有体现出特殊训练的过程。假如还有一些动物也要直立行走，增加这个行为，如何体现出规范性、标准性呢？体现出它们是特殊的经过训练的动物呢？
 * 这里我们想到了抽象类，因为抽象类中抽象方法，可以强制约束子类实现它，这样就是一种标准和规范，体现了它经过了特殊训练，和之前不同了。
 *
 * 于是我们定义抽象类，给出抽象方法，让超级猫狗类去继承这个抽象类，可行吗？
 *
 * 理想很美好，现实很骨感。显然做不到，因为Java不支持多继承。除开这点这么做也不是完美的，问题是：
 *
 * 这个抽象类里面是对功能和行为的抽象，缺少属性（单独一个直立行走的行为是一个什么对象？）所以单独的行为不应该被抽象为类，不符合类的定义。
 * 继承这个抽象类也不符合继承的"is-a"关系，这里不适用继承（还是上面那句话，行为根本不是个体）
 * 于是，我们就迫切需要一种全新的数据类型，这种全新的数据类型：
 *
 * 不强调属性，只强调行为的抽象，"继承"它表示功能的扩展。
 * 在一个类继承某个类后，还能继续"继承"，不受Java单继承限制。
 * 没有"is-a"这种继承关系的限制。
 * 最好还有抽象方法。（因为它能表示规范和标准）
 * 这种全新的数据类型，就是接口（interface）。
 *
 * 上面四条，其实已经描述了接口的特点，接口是一种表示对行为抽象的，不受Java多继承限制的，用来作为功能扩展标准的一种引用数据类型。它的定义语法如下：
 * [访问权限修饰符] interface 接口名{}
 * 解释:
 *      1.接口定义不过是把class关键字换成了interface
 *      2.接口是和class类同等级别的数据类型,同属于引用数据类型
 *      3.接口的访问权限修饰符和class类的定义是一致的
 *      4.接口名和类名一样,"大驼峰"式书写
 *          由于接口比较特殊,有些程序员喜欢在接口的前面加上大写字母"I",表示它是一个接口
 *
 * 接口定义完毕后,注意,接口中是可以定义抽象方法的,而且接口的目的是表示对功能的扩展,接口中应该必须有抽象方法.
 *
 * 接口定义完毕后,可以让一个普通类来"继承"一个接口,接口的"继承",更专业的应该叫"实现"(implements关键字)
 * 特殊的,当某个类既继承又实现时,要先继承再实现
 *
 * 类在继承类时,是单继承的,但是实现接口时,可以多实现.
 *
 * 类在实现接口后,接口可以看成是类的"父接口"
 * 也可以用父接口引用指向子类对象,也存在多态现象
 *
 * 接口其实也是抽象的,接口不能创建对象.
 *
 * 使用接口有如下优点：
 * 接口不受单继承限制，这是接口非常重要的优点。
 * 接口不是类，它和它的实现类，也不需要存在"is-a"关系，接口比抽象类的使用更加灵活。
 * 程序开发中将接口和它的实现类之间的关系，称之为"like-a"关系。只要是实现了Xxx的功能，就像Xxx。
 *      比如一个盒子,只要实现了制冷和制热,那它就具有空调的功能,那它就像空调
 *
 * 接口表示一种开发标准，一种规范。表示对功能的扩展，它只关注行为，不关注属性。
 *
 * @since 14:47
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) {
        // SuperCat能够有几种方式创建对象?
        // sc引用可以调用所有方法
        SuperCat sc = new SuperCat();
        // c引用可以调用Cat类中存在的方法
        Cat c = new SuperCat();
        c.shout();
        // ise可以调用父接口ISpecialExercise中存在的方法
        ISpecialExercise ise = new SuperCat();
        ise.walkUpright();
        IA ia = new SuperCat();
        ia.test();

        // new IA();
    }
}

abstract class Animal {
    public abstract void shout();
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}

class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}

// 重新定义两个特殊的猫和狗类
class SuperCat extends Cat implements ISpecialExercise, IA {
    @Override
    public void walkUpright() {
        System.out.println("我是超威蓝猫,我能直立行走!");
    }

    @Override
    public void test() {
        System.out.println("我是IA接口的抽象方法实现");
    }
}

class SuperDog extends Dog implements ISpecialExercise {
    @Override
    public void walkUpright() {
        System.out.println("我是哮天犬,我能直立行走!");
    }
}
//Java不支持多继承
abstract class SpecialExercise {
    // 特殊训练,能够直立行走
    public abstract void walkUpright();
}

interface ISpecialExercise {
    // 定义抽象方法
    public abstract void walkUpright();
}

interface IA {
    public abstract void test();
}
