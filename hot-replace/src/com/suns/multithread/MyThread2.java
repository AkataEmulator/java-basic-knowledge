package com.suns.multithread;

/**
 * @author : sunshuo
 * @date : 2020-07-27 21:26:02
 * @desc :
 */
public class MyThread2 extends Thread {
    private final String msg;

    public MyThread2(String msg) {
        this.msg = msg;
    }

    private void doSomething() {
        System.out.println("execute MyThread2: " + Thread.currentThread().getName());
        System.out.println(msg);
    }

    @Override
    public void run() {
        doSomething();
    }
}
