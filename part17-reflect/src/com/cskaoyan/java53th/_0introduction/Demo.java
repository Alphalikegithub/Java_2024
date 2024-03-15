package com.cskaoyan.java53th._0introduction;

/**
 * 什么是反射?
 * 通俗的说,反射就是获取类型的Class对象,然后在程序的运行期间动态的对该类型执行一些操作
 * 换句话说,反射就是Class类型的API操作!
 * 反射技术应用的起点就是获取某个类的Class对象。
 *
 * 那么如何获取Class对象呢?
 *      1.依赖于Object类的final成员方法getClass
 *      此方法任何对象都可以调用,来获取其类型的Class对象
 *      这个方法不常用于获取Class对象,常用于比较判断两个对象的类型是否一致(equals方法排它性校验)
 *
 *      2.Java的每一种数据类型,都有一个隐含的静态属性,"数据类型名.class"
 *      用于获取该类型的Class对象,所有类型都有,包括基本数据类型
 *      这种方式获取Class对象在反射当中也不是常用手段,主要用于给泛型传参,给方法调用传参等
 *      比如某个方法的形参列表是(Class... vars);
 *      此时调用方法可以传参(String.class,int.class)
 *      注意事项:
 *      基本数据类型和它的包装类型的".class"不是同一个对象
 *      因为int和Integer确实不是相同类型,那么它们的Class对象就不应该相同
 *
 *      3.(最常用)
 *      利用Class类型的静态成员方法
 *      Class.forName(全限定类名);
 *      来获取此全限定类名的类型的Class对象
 *
 * 细节/注意:
 *      1.不论哪种方式获取Class对象,相同类型的Class对象都是唯一的
 *      2.不论哪种方式获取Class对象,Class对象都不是它们方法创建的,而是类加载器在类加载的加载阶段在堆上创建的
 *      3.第三种方式是最常用的方式，因为它直接用一个全限定类名字符串指定一个类，更加灵活。
 *      尤其是在配合配置文件使用的时候，它的优越性秒杀其它方式。
 *
 * 总结类加载的时机:
 *      1.直接使用java命令来运行某个主类，也就是启动某个类的main()方法，会类加载该类型。
 *      2.创建类的对象。(首次)
 *      3.访问类的静态成员（首次）
 *      4.触发某个子类的类加载，会优先类加载父类。
 *      5.利用反射来强制获取类型的Class对象,会触发该类型的类加载
 *      比如Class.forName(全限定类名);
 *
 * @since 10:57
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Student s = new Student();
        Class stuClazz = s.getClass();
        Class stuClazz2 = Student.class;
        Class intClazz = int.class;
        Class integerClazz = Integer.class;
        System.out.println(intClazz == integerClazz);

        Class stuClazz3 = Class.forName("com.cskaoyan._2reflect._0introduction.Student");

        System.out.println(stuClazz == stuClazz2);
        System.out.println(stuClazz == stuClazz3);
        System.out.println(stuClazz2 == stuClazz3);
    }
}

class Student {
}
