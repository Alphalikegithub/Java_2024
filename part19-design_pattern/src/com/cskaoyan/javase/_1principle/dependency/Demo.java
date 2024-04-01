package com.cskaoyan.javase._1principle.dependency;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-03-18 16:06
 **/

public class Demo {
    public static void main(String[] args) {
        //调用Person对象
        Person person = new Person();
        //调用receiveMsg
//        person.receiveMsg(new Email());
//        person.receiveMsg(new QQ());
        person.receiveMsg2(new Email());
        person.receiveMsg2(new QQ());
    }
}

//定义一个接口
interface IReceiver {
    //定义一个receive方法
    String receive();
}

//定义一个电子邮件类
class Email implements IReceiver {
    //重写receive方法
    @Override
    public String receive() {
        return "Email : Hello!";
    }
}

class QQ implements IReceiver {

    @Override
    public String receive() {
        return "QQ : Hello!";
    }
}

//定义一个Person类
/*Email是一个具体的类（是细节实现） 我们不应该依赖于具体的类，而应该依赖抽象类*/
class Person {
    //定义接收消息的方法  接收电子邮件的方法
    public void receiveMsg(Email email) {
        String msg = email.receive();
        System.out.println(msg);
    }

    //当下通信双方传递消息，除了Email还有QQ　微信．．．
    public void receiveMsg(QQ qq) {
        String msg = qq.receive();
        System.out.println(msg);
    }
    //按照依赖倒置原则
    //需要定义一个能够接收所有消息的方法(只要是实现IReceiver接口)
    public void receiveMsg2(IReceiver iReceiver){
        String receive = iReceiver.receive();
        System.out.println(receive);
    }

}
