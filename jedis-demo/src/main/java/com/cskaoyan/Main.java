package com.cskaoyan;

import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //System.out.println("Hello world!");
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //加入存在密码
        //jedis.auth("");
        /*jedis.set("name","葫芦娃");
        Thread.sleep(1000);*/
        String name = jedis.get("name");
        System.out.println("name = " + name);
//        jedis.hmset()
//        jedis.lpop()
        jedis.close();
    }

}