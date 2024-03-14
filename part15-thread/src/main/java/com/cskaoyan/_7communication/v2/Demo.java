package com.cskaoyan._7communication.v2;

/**
 * 两个生产者和两个消费者线程,来同时消费仓库中的一台手机
 *
 * @since 16:18
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class Demo {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        ConsumerTask consumerTask = new ConsumerTask(warehouse);
        ProducerTask producerTask = new ProducerTask(warehouse);

        new Thread(producerTask, "生产者1号").start();
        new Thread(producerTask, "生产者2号").start();
        new Thread(consumerTask, "消费者1号").start();
        new Thread(consumerTask, "消费者2号").start();
    }
}


// 仓库类型,用于存储商品
class Warehouse {
    // 仓库中的一台手机
    private Phone phone;

    // 生产者生产手机的方法
    public void putPhone(Phone phone) {
        this.phone = phone;
    }

    // 消费者消费手机的方法
    public Phone consumePhone() {
        Phone sellPhone = phone;
        phone = null;
        return sellPhone;
    }

    // 判断仓库有无手机,true表示仓库为空,,false表示仓库已经有手机了
    public boolean isEmpty() {
        return phone == null;
    }
}

// 生产者模型
class ProducerTask implements Runnable {
    private Warehouse warehouse;
    private static Phone[] phones = new Phone[5];

    static {
        phones[0] = new Phone("iPhone15", 7000);
        phones[1] = new Phone("小米14", 6000);
        phones[2] = new Phone("华为P60", 8000);
        phones[3] = new Phone("OPPO find N3", 9000);
        phones[4] = new Phone("三星", 4000);
    }

    public ProducerTask(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    // 生产者生产手机,并把手机放入仓库中
    public void producePhone() {
        int randomIndex = (int) (Math.random() * phones.length);
        Phone random = phones[randomIndex];
        System.out.println(Thread.currentThread().getName() + "生产了" + random);
        warehouse.putPhone(random);
    }


    @Override
    public void run() {
        /*
        1.生产者的思路,方法执行就要判断仓库的状态:
            a.如果仓库是空的,那就生产一台手机,立刻通知notify消费者来消费
            b.如果仓库是非空的,那就不做任何操作,并且立刻wait自己,不能继续生产了
     */
        while (true) {
            synchronized (warehouse) {
                if (warehouse.isEmpty()) {
                    producePhone();
                    warehouse.notifyAll();
                } else {
                    // 仓库已经有手机了,那就wait自己不再生产
                    try {
                        warehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

// 消费者模型
class ConsumerTask implements Runnable {
    private Warehouse warehouse;

    public ConsumerTask(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void buyPhone() {
        Phone phone = warehouse.consumePhone();
        System.out.println(Thread.currentThread().getName() + "消费了" + phone);
    }

    @Override
    public void run() {
        /*

        2.消费者的思路,方法执行就要判断仓库的状态:
            a.如果仓库是空的,那就应该立刻wait自己,使自己阻塞
            b.如果仓库是非空,那就应该消费掉这台手机,立刻唤醒通知生产者来生产
         */
        while (true) {
            synchronized (warehouse) {
                if (warehouse.isEmpty()) {
                    try {
                        warehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    buyPhone();
                    warehouse.notifyAll();
                }
            }
        }
    }
}

// 商品类型
class Phone {
    private String name;
    private double price;

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}