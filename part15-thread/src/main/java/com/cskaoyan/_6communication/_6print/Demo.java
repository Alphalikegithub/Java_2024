package com.cskaoyan._6communication._6print;

/**
 * 编写两个线程,一个线程打印1-10的整数，另一个线程打印字母A-E。打印结果为12A34B56C78D910E
 * 即按照整数和字母的顺序从小到大打印，并且每打印两个整数后，打印一个字母，交替循环打印
 *
 * 两个线程执行,其中线程1执行两次,然后线程2执行一次,接下来就循环
 * 如何实现呢?
 * 提示:
 * 定义一个Printer类,然后定义两个方法用于打印数字和字母(用一个计数器从1开始,每打印一次就++,3的倍数次就打印字母,其余打印数字)
 * 创建两个Task类型,然后循环中调用Printer类的两个方法用于打印数字和字母。
 * 启动线程,执行任务
 *
 * 思路:
 * 计数,判断打印的次数
 * 如果打印的次数是3或者3的倍数,那就是打印字母,打印字母完了就notify唤醒
 * 反之,如果不是3或者3的倍数,那就是打印数字,打印数字完了就notify唤醒
 * 并且在(打印字母和打印数字线程)各自内部,如果判断出不是自己打印的count,那就wait自己
 *
 * @since 17:41
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new PrintLetter("打印字母的线程", printer).start();
        new PrintNumber("打印数字的线程", printer).start();
    }
}

// 使用同步方法来进行线程同步,以及等待唤醒
class Printer {
    private int count = 1;

    synchronized void printLetter(char c) {
        if (count % 3 != 0) {
            // 不是打印字母,该打印数字,所以wait自己
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 是打印字母,是3的倍数
        System.out.print(c);
        notify();
        count++;
    }

    synchronized void printNumber(int c) {
        if (count % 3 == 0) {
            // 不是打印数字,该打印字母,所以wait自己
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 是打印数字,不是3的倍数
        System.out.print(c);
        notify();
        count++;
    }
}

class PrintLetter extends Thread {
    private Printer printer;

    public PrintLetter(String name, Printer printer) {
        super(name);
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 'a'; i <= 'z'; i++) {
            printer.printLetter(((char) i));
        }
    }
}

class PrintNumber extends Thread {
    private Printer printer;

    public PrintNumber(String name, Printer printer) {
        super(name);
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 52; i++) {
            printer.printNumber(i);
        }
    }
}