package com.suns.multithread;

/**
 * @author : sunshuo
 * @date : 2020-07-27 21:18:06
 * @desc : 多线程测试类
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("hello1");
        // myThread1.run();
        // Thread thread01 = new Thread(myThread1);
        // thread01.setName("t1");
        // thread01.start();

        MyThread2 myThread2 = new MyThread2("hello2");
        myThread2.setName("t2");
        myThread2.start();
    }
}
