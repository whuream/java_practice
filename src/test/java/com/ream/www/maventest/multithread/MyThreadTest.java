package com.ream.www.maventest.multithread;

import junit.framework.TestCase;

/**
 * Created by tong on 1/25/16.
 */
public class MyThreadTest extends TestCase {

    public void test() {
        Thread t1 = new Thread(new MyThread("1"));

        Thread t2 = new Thread(new MyThread("2"));

        t1.start();

        t2.start();

        System.out.println("main thread");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();

        t2.interrupt();

    }

    public void test2() {
        Thread t1 = new Thread(new MyThread("1"));

        Thread t2 = new Thread(new MyThread("2"));

        t1.start();

        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testWhile(){
        Thread t1 = new Thread(new MyThreadWhile("1"));

        Thread t2 = new Thread(new MyThreadWhile("2"));

        t1.start();

        t2.start();

        System.out.println("main thread");


        t1.interrupt();

        t2.interrupt();

        // does not stop
        System.out.println("call interrupt");

        t1.stop();

        t2.stop();

        // stop
        System.out.println("call stop");

        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}