package com.suns.multithread;

/**
 * @author : sunshuo
 * @date : 2020-07-27 21:18:47
 * @desc : 实现 Runnable 接口
 */
public class MyThread1 implements Runnable {
    private final String msg;

    public MyThread1(String msg) {
        this.msg = msg;
    }

    private void doSomething() {
        System.out.println("execute MyThread1: " + Thread.currentThread().getName());
        System.out.println(msg);
    }

    @Override
    public void run() {
        doSomething();
    }
}
